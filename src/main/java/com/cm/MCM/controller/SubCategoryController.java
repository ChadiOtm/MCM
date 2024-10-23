package com.cm.MCM.controller;

import com.cm.MCM.dto.SubCategoryDTO;
import com.cm.MCM.service.SubCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subcategories")
@AllArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<SubCategoryDTO> addNewSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
        SubCategoryDTO savedSubCategory = subCategoryService.addNewSubCategory(subCategoryDTO);
        return new ResponseEntity<>(savedSubCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubCategoryDTO>> getAllSubCategories() {
        List<SubCategoryDTO> subCategories = subCategoryService.getAllSubCategories();
        return ResponseEntity.ok(subCategories);
    }

    @GetMapping("/{subCategoryId}")
    public ResponseEntity<SubCategoryDTO> findSubCategoryById(@PathVariable UUID subCategoryId) {
        SubCategoryDTO subCategory = subCategoryService.findSubCategoryById(subCategoryId);
        return ResponseEntity.ok(subCategory);
    }

    @PutMapping("/{subCategoryId}")
    public ResponseEntity<SubCategoryDTO> updateSubCategory(
            @PathVariable UUID subCategoryId,
            @RequestBody SubCategoryDTO subCategoryDTO) {
        subCategoryDTO.setSubCategoryId(subCategoryId);
        SubCategoryDTO updatedSubCategory = subCategoryService.updateSubCategory(subCategoryDTO);
        return ResponseEntity.ok(updatedSubCategory);
    }

    @DeleteMapping("/{subCategoryId}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable UUID subCategoryId) {
        subCategoryService.deleteSubCategory(subCategoryId);
        return ResponseEntity.noContent().build();
    }
}