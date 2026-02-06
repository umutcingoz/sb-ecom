package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService{
    private List<Category> categories = new ArrayList<>();
    private long nextId = 1;

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(long categoryId){
//        boolean deleted = categories.removeIf(category -> category.getCategoryId() == categoryId);
//        if (deleted) return "Category with ID: " + categoryId + " deleted successfully";
//        return "Category with ID: " + categoryId + " does not exist";
//
//        Category category = categories.stream().filter(category1 -> category1.getCategoryId().equals(categoryId)).findFirst().orElse(null);
//        if (category == null) {
//            return "Category with id: " + categoryId + " not exist.";
//        }
//        else {
//            categories.remove(category);
//            return "Category with id: " + categoryId + " deleted succesfully.";
//        }

        Category category = categories.stream()
                .filter(category1 -> category1.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));

        categories.remove(category);
        return "Category with id: " + categoryId + " deleted succesfully.";

    }
}
