package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;


@Controller
public class ReviewController {


    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }


    @RequestMapping("/review/{id}")
    public String displayReview(@PathVariable long id, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(id);
        model.addAttribute("review", retrievedReview);
        return "review-view";

    }
}
