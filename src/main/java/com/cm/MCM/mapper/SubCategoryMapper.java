package com.cm.MCM.mapper;

import com.cm.MCM.dto.SubCategoryDTO;
import com.cm.MCM.model.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    @Mapping(source = "category.name", target = "categoryName")
    SubCategoryDTO SubCategoryToSubCategoryDTO(SubCategory subCategory);

    @Mapping(target = "category", ignore = true)
    SubCategory SubCategoryDTOToSubCategory(SubCategoryDTO subCategoryDTO);

    List<SubCategoryDTO> SubCategoryListToSubCategoryListDTO(List<SubCategory> subCategories);
}