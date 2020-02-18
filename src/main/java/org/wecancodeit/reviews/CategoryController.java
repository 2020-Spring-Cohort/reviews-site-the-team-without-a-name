package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping("/categories/{reviewsCategory}")
    public String displaySingleReview(@PathVariable String reviewType, Model model) {
        Review retrieveType = categoryStorage.findCategoryByType(reviewType);
        model.addAttribute("category", retrieveType);

        return "categoryView";
    }
}
