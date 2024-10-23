package com.cm.MCM.mapper;

import com.cm.MCM.dto.SubCategoryDTO;
import com.cm.MCM.model.Category;
import com.cm.MCM.model.SubCategory;
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
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategoryDTO SubCategoryToSubCategoryDTO(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        subCategoryDTO.setCategoryName( subCategoryCategoryName( subCategory ) );
        subCategoryDTO.setSubCategoryId( subCategory.getSubCategoryId() );
        subCategoryDTO.setName( subCategory.getName() );
        subCategoryDTO.setDescription( subCategory.getDescription() );
        subCategoryDTO.setImageUrl( subCategory.getImageUrl() );

        return subCategoryDTO;
    }

    @Override
    public SubCategory SubCategoryDTOToSubCategory(SubCategoryDTO subCategoryDTO) {
        if ( subCategoryDTO == null ) {
            return null;
        }

        SubCategory subCategory = new SubCategory();

        subCategory.setSubCategoryId( subCategoryDTO.getSubCategoryId() );
        subCategory.setName( subCategoryDTO.getName() );
        subCategory.setDescription( subCategoryDTO.getDescription() );
        subCategory.setImageUrl( subCategoryDTO.getImageUrl() );

        return subCategory;
    }

    @Override
    public List<SubCategoryDTO> SubCategoryListToSubCategoryListDTO(List<SubCategory> subCategories) {
        if ( subCategories == null ) {
            return null;
        }

        List<SubCategoryDTO> list = new ArrayList<SubCategoryDTO>( subCategories.size() );
        for ( SubCategory subCategory : subCategories ) {
            list.add( SubCategoryToSubCategoryDTO( subCategory ) );
        }

        return list;
    }

    private String subCategoryCategoryName(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }
        Category category = subCategory.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
