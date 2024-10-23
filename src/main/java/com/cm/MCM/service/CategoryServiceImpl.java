package com.cm.MCM.service;


import com.cm.MCM.dto.CategoryDTO;
import com.cm.MCM.mapper.CategoryMapper;
import com.cm.MCM.model.Category;
import com.cm.MCM.model.City;
import com.cm.MCM.repository.CategoryRepository;
import com.cm.MCM.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private CityRepository cityRepository;

    @Override
    @Transactional
    public CategoryDTO addNewCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        Category category = categoryMapper.CategoryDTOtoCategory(categoryDTO);

        // Fetch existing City by name
        if (categoryDTO.getCityName() != null) {
            City city = cityRepository.findByName(categoryDTO.getCityName())
                    .orElseThrow(() -> new EntityNotFoundException("City not found: " + categoryDTO.getCityName()));
            category.setCity(city);
        }

        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.CategoryToCategoryDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.CategoryListToCategoryListDTO(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO findCategoryById(UUID categoryId) {
        return categoryMapper.CategoryToCategoryDTO(
                categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId))
        );
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null || categoryDTO.getCategoryId() == null) {
            throw new IllegalArgumentException("Category and Category ID cannot be null");
        }

        // First check if the category exists
        Category existingCategory = categoryRepository.findById(categoryDTO.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryDTO.getCategoryId()));

        // Update the existing category with new values
        Category categoryToUpdate = categoryMapper.CategoryDTOtoCategory(categoryDTO);

        // Handle City update if provided
        if (categoryDTO.getCityName() != null) {
            City city = cityRepository.findByName(categoryDTO.getCityName())
                    .orElseThrow(() -> new EntityNotFoundException("City not found: " + categoryDTO.getCityName()));
            categoryToUpdate.setCity(city);
        } else {
            categoryToUpdate.setCity(existingCategory.getCity());  // Preserve existing city if not provided
        }

        // Save the updated category
        Category savedCategory = categoryRepository.save(categoryToUpdate);
        return categoryMapper.CategoryToCategoryDTO(savedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}