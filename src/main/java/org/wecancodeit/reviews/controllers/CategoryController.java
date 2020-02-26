package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;



@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;
    private ReviewRepository reviewRepo;
    private ReviewStorage reviewStorage;
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryStorage categoryStorage, CategoryRepository categoryRepo, ReviewRepository reviewRepo) {
        this.categoryStorage = categoryStorage;
        this.categoryRepo = categoryRepo;
        this.reviewRepo = reviewRepo;

    }

    @RequestMapping("/categories")
    public String displayCategory(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categories-view";

    }

    @RequestMapping("/categories/{categoryType}")
    public String displaySingleCategory(@PathVariable String categoryType, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryByType(categoryType);
        model.addAttribute("category", retrieveCategory);

        return "category-view";
    }

    @PostMapping("/add-category")
    public String addCategory(@RequestParam String type) {
        categoryStorage.store(new Category(type));
        return "redirect:categories";
    }

    @PostMapping("/categories/{categoryType}/add-review")
    public String addReviewToCategory(@PathVariable String categoryType,
                                      @RequestParam String category, String reviewTitle, String reviewBody){
        Review reviewToAddToCategory = new Review(categoryRepo.findByType(category).get(), reviewTitle, reviewBody);
        reviewRepo.save(reviewToAddToCategory);
//        Category categoryToAddReviewTo= categoryStorage.findCategoryByType(category.getType());
//        categoryToAddReviewTo.addReviewToCategory(reviewToAddToCategory);
//        categoryStorage.store(categoryToAddReviewTo);
        return "redirect:/categories/" + categoryType;

    }
}
