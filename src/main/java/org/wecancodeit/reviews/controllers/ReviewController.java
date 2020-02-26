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
import org.wecancodeit.reviews.storage.repositories.CommentRepository;


@Controller
public class ReviewController {


    private ReviewStorage reviewStorage;
    private CommentStorage commentStorage;
    private CommentRepository commentRepo;


    public ReviewController(ReviewStorage reviewStorage, CommentRepository commentRepo) {
        this.reviewStorage = reviewStorage;
        this.commentRepo = commentRepo;
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

    @PostMapping("/review/{id}/add-comment")
    public String addComment(@RequestParam String comment, Review review, @PathVariable Long id) {
        Comment commentToAddToReview = new Comment(comment, reviewStorage.findReviewById(id));
//        Optional<Comment> commentToAddOpt = commentRepo.findByName()
        commentRepo.save(commentToAddToReview);
        Review reviewToAddCommentTo = reviewStorage.findReviewById(id);
        reviewToAddCommentTo.addCommentToReview(commentToAddToReview);
        reviewStorage.store(reviewToAddCommentTo);
        return "redirect:/review/" + id;

    }
}