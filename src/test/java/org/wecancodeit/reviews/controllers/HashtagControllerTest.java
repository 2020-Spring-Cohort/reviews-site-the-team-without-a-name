package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
        Hashtag testHashtag = new Hashtag("");
        testHashtag = new Hashtag("Billy");
        when(mockStorage.findHashtagById(1L)).thenReturn(testHashtag);
    }
    @Test
    public void displayHashtagReturnsHashtagTemplate(){
        String result = underTest.displayHashtag(1L, model);

    }
}

