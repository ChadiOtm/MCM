package com.cm.MCM.mapper;

import com.cm.MCM.dto.CategoryDTO;
import com.cm.MCM.model.Category;
import com.cm.MCM.model.City;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:28:25+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO CategoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCityName( categoryCityName( category ) );
        categoryDTO.setCategoryId( category.getCategoryId() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setDescription( category.getDescription() );
        categoryDTO.setImageUrl( category.getImageUrl() );

        return categoryDTO;
    }

    @Override
    public Category CategoryDTOtoCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDTO.getCategoryId() );
        category.setName( categoryDTO.getName() );
        category.setDescription( categoryDTO.getDescription() );
        category.setImageUrl( categoryDTO.getImageUrl() );

        return category;
    }

    @Override
    public List<CategoryDTO> CategoryListToCategoryListDTO(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( categories.size() );
        for ( Category category : categories ) {
            list.add( CategoryToCategoryDTO( category ) );
        }

        return list;
    }

    @Override
    public List<Category> CategoryDTOListToCategoryList(List<CategoryDTO> categoryDTOS) {
        if ( categoryDTOS == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDTOS.size() );
        for ( CategoryDTO categoryDTO : categoryDTOS ) {
            list.add( CategoryDTOtoCategory( categoryDTO ) );
        }

        return list;
    }

    private String categoryCityName(Category category) {
        if ( category == null ) {
            return null;
        }
        City city = category.getCity();
        if ( city == null ) {
            return null;
        }
        String name = city.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
