package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    private ReviewController underTest;
    private Model model;
    private ReviewStorage mockStorage;
    private Review testReview;


    @BeforeEach
    void setUp(){
        mockStorage = mock(ReviewStorage.class);
        underTest = new ReviewController(mockStorage);
        model = mock(Model.class);
        Category testCategory = new Category("Sedam");
        Hashtag testHashtag = new Hashtag("");
        testReview = new Review(testCategory, "I Really Love This Car OMG", "Great Review");
        when(mockStorage.findReviewById(1L)).thenReturn(testReview);

    }

    @Test
    public void displayReviewReturnsReviewTemplate(){
        String result = underTest.displayReview(1L, model);
        assertThat(result).isEqualTo("review-view");

    }

}
