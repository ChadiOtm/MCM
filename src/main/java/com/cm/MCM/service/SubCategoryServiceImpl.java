package com.cm.MCM.service;

import com.cm.MCM.dto.SubCategoryDTO;
import com.cm.MCM.mapper.SubCategoryMapper;
import com.cm.MCM.model.Category;
import com.cm.MCM.model.SubCategory;
import com.cm.MCM.repository.CategoryRepository;
import com.cm.MCM.repository.SubCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public SubCategoryDTO addNewSubCategory(SubCategoryDTO subCategoryDTO) {
        if (subCategoryDTO == null) {
            throw new IllegalArgumentException("SubCategory cannot be null");
        }

        SubCategory subCategory = subCategoryMapper.SubCategoryDTOToSubCategory(subCategoryDTO);

        if (subCategoryDTO.getCategoryName() != null) {
            Category category = categoryRepository.findByName(subCategoryDTO.getCategoryName())
                    .orElseThrow(() -> new EntityNotFoundException("Category not found: " + subCategoryDTO.getCategoryName()));
            subCategory.setCategory(category);
        }

        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        return subCategoryMapper.SubCategoryToSubCategoryDTO(savedSubCategory);
    }

    @Override
    public List<SubCategoryDTO> getAllSubCategories() {
        return subCategoryMapper.SubCategoryListToSubCategoryListDTO(subCategoryRepository.findAll());
    }

    @Override
    public SubCategoryDTO findSubCategoryById(UUID subCategoryId) {
        return subCategoryMapper.SubCategoryToSubCategoryDTO(
                subCategoryRepository.findById(subCategoryId)
                        .orElseThrow(() -> new EntityNotFoundException("SubCategory not found with id: " + subCategoryId))
        );
    }

    @Override
    @Transactional
    public SubCategoryDTO updateSubCategory(SubCategoryDTO subCategoryDTO) {
        if (subCategoryDTO == null || subCategoryDTO.getSubCategoryId() == null) {
            throw new IllegalArgumentException("SubCategory and SubCategory ID cannot be null");
        }

        SubCategory existingSubCategory = subCategoryRepository.findById(subCategoryDTO.getSubCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("SubCategory not found with id: " + subCategoryDTO.getSubCategoryId()));

        SubCategory subCategoryToUpdate = subCategoryMapper.SubCategoryDTOToSubCategory(subCategoryDTO);

        if (subCategoryDTO.getCategoryName() != null) {
            Category category = categoryRepository.findByName(subCategoryDTO.getCategoryName())
                    .orElseThrow(() -> new EntityNotFoundException("Category not found: " + subCategoryDTO.getCategoryName()));
            subCategoryToUpdate.setCategory(category);
        } else {
            subCategoryToUpdate.setCategory(existingSubCategory.getCategory());
        }

        SubCategory savedSubCategory = subCategoryRepository.save(subCategoryToUpdate);
        return subCategoryMapper.SubCategoryToSubCategoryDTO(savedSubCategory);
    }

    @Override
    @Transactional
    public void deleteSubCategory(UUID subCategoryId) {
        subCategoryRepository.deleteById(subCategoryId);
    }
}