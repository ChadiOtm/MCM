package com.cm.MCM.service;

import com.cm.MCM.dto.SubCategoryDTO;

import java.util.List;
import java.util.UUID;

public interface SubCategoryService {

    SubCategoryDTO addNewSubCategory(SubCategoryDTO subCategoryDTO);

    List<SubCategoryDTO> getAllSubCategories();

    SubCategoryDTO findSubCategoryById(UUID subCategoryId);

    SubCategoryDTO updateSubCategory(SubCategoryDTO subCategoryDTO);

    void deleteSubCategory(UUID subCategoryId);
}