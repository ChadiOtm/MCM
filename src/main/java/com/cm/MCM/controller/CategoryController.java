package com.cm.MCM.controller;


import com.cm.MCM.dto.CategoryDTO;
import com.cm.MCM.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> addNewCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.addNewCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> listOfCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(listOfCategories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable UUID categoryId) {
        CategoryDTO category = categoryService.findCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable UUID categoryId,
            @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setCategoryId(categoryId); // ensure we are updating the category we want
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}