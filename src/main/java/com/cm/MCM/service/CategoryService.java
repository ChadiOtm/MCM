package com.cm.MCM.service;


import com.cm.MCM.dto.CategoryDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public CategoryDTO addNewCategory(CategoryDTO categoryDTO);

    public List<CategoryDTO> getAllCategories();

    public CategoryDTO findCategoryById(UUID categoryId);

    public CategoryDTO updateCategory(CategoryDTO categoryDTO);

    public void deleteCategory(UUID categoryId);
}
