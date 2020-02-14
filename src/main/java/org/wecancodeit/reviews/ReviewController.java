package org.wecancodeit.reviews;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ReviewController {
    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage mockStorage) {
    }

    public void displaySingleReview(String reviewCategory) {
    }


    @RequestMapping("/reviews/{reviewsCategory}")
    public String displaySingleReview(@PathVariable String category, Model model) {
        Review retrieveReview = reviewStorage.findReviewByCategory(category);
        model.addAttribute("review", retrieveReview);

        return "reviewView";
    }
}
