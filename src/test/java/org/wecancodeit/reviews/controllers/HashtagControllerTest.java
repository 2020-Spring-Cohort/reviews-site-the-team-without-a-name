package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class HashtagControllerTest {
    private HashtagController underTest;
    private Model model;
    private HashtagStorage mockStorage;
    private Hashtag testHashtag;

    @BeforeEach
    void setUp() {
        mockStorage = mock(HashtagStorage.class);
        underTest = new HashtagController(mockStorage);
        model = mock(Model.class);
        Category testCategory = new Category("Sedan");
        testHashtag = new Hashtag("Billy");
        when(mockStorage.findHashtagById(1L)).thenReturn(testHashtag);
    }
    @Test
    public void displayHashtagReturnsHashtagTemplate(){
        String result = underTest.displayHashtag(1L, model);
        assertThat(result).isEqualTo("hashtag-view");

    }
    @Test
    public void displayHashtagInteractsWithDependenciesCorrectly(){
        underTest.displayHashtag(1L,model);
        verify(mockStorage).findHashtagById(1L);
        verify(model).addAttribute("hashtag", testHashtag);
    }
    @Test
    public void displayBookMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hashtag/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("hashtag-view"))
                .andExpect(model().attributeExists("hashtag"))
                .andExpect(model().attribute("hashtag", testHashtag));
    }

}

