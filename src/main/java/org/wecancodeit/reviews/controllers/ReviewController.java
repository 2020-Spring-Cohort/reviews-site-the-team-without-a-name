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
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;




@Controller
public class ReviewController {


    private ReviewStorage reviewStorage;
    private CommentStorage commentStorage;

    public ReviewController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }


    @RequestMapping("/review/{id}")
    public String displayReview(@PathVariable Long id, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(id);
        model.addAttribute("review", retrievedReview);
        return "review-view";

    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam Category category, String title, String reviewBody, Hashtag... hashtag) {
        reviewStorage.store(new Review(category, title, reviewBody, hashtag));
        return "redirect:review";
    }

    @PostMapping("{id}/add-comment")
    public String addComment(@RequestParam String comment, Review review) {
        Comment commentToStore = new Comment(comment, review);
        commentStorage.store(commentToStore);
        return "redirect:review";
    }
}