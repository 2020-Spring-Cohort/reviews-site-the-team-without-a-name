package org.wecancodeit.reviews;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ReviewController {
    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }


    @RequestMapping("/category/{reviewsCategory}")
    public String displaySingleReview(@PathVariable String reviewsCategory, Model model) {
        Review retrieveReview = reviewStorage.findReviewByCategory(reviewsCategory);
        model.addAttribute("category", retrieveReview);

        return "reviewView";
    }
}
