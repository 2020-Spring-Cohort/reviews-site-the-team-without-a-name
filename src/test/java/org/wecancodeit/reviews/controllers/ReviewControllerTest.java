package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;
import org.wecancodeit.reviews.storage.repositories.CommentRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReviewControllerTest {

    private ReviewController underTest;
    private Model model;
    private ReviewStorage mockStorage;
    private Review testReview;


    @BeforeEach
    void setUp(){
        mockStorage = mock(ReviewStorage.class);
        CommentRepository commentRepo = mock(CommentRepository.class);
        underTest = new ReviewController(mockStorage, commentRepo);
        model = mock(Model.class);
        Category testCategory = new Category("Sedan");
        Hashtag testHashtag = new Hashtag("");
        testReview = new Review(testCategory, "I Really Love This Car OMG", "Great Review");
        when(mockStorage.findReviewById(1)).thenReturn(testReview);

    }

    @Test
    public void displayReviewReturnsReviewTemplate(){
        String result = underTest.displayReview(1L, model);
        assertThat(result).isEqualTo("review-view");

    }

    @Test
    public void displayReviewInteractsWithDependenciesCorrectly(){

        underTest.displayReview(1L, model);
        verify(mockStorage).findReviewById(1);
        verify(model).addAttribute("review", testReview);
    }

    @Test
    public void displayReviewMappingIsCorrect() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/review/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("review-view"))
                .andExpect(model().attributeExists("review"))
                .andExpect(model().attribute("review", testReview));

    }

}
