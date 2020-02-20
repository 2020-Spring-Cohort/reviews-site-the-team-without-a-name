package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;


@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }
    @RequestMapping("/categories")
    public String displayCategory(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categoriesView";

    }

    @RequestMapping("/categories/{categoryType}")
    public String displaySingleCategory(@PathVariable String categoryType, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryByType(categoryType);
        model.addAttribute("category", retrieveCategory);

        return "categoryView";
    }
}