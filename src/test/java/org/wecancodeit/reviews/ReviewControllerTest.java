package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class ReviewControllerTest {

    private MockMvc mockMvc;
    private ReviewController underTest;
    private ReviewStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(ReviewStorage.class);
        underTest = new ReviewController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneReview(){
        Review testReview = new Review("Car");
        when(mockStorage.findReviewByCategory("Sedan")).thenReturn(testReview);

        underTest.displaySingleReview("Sedan", mockModel);

        verify(mockStorage).findReviewByCategory("Sedan");
        verify(mockModel).addAttribute("category", testReview);

    }

}


