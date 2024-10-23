package com.cm.MCM.mapper;

import com.cm.MCM.dto.CategoryDTO;
import com.cm.MCM.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "cityName", source = "city.name")
    CategoryDTO CategoryToCategoryDTO(Category category);

    @Mapping(target = "city", ignore = true)
    Category CategoryDTOtoCategory(CategoryDTO categoryDTO);

    @Mapping(target = "cityName", source = "city.name")
    List<CategoryDTO> CategoryListToCategoryListDTO(List<Category> categories);

    @Mapping(target = "city", ignore = true)
    List<Category> CategoryDTOListToCategoryList(List<CategoryDTO> categoryDTOS);

}
