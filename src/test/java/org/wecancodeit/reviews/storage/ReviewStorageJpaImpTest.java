package org.wecancodeit.reviews.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImpTest {
    private ReviewRepository reviewRepo;
    private ReviewStorage underTest;
    private Review testReview;


    @BeforeEach
    void setUp(){
        reviewRepo = mock(ReviewRepository.class);
        underTest = new ReviewStorageJpaImp(reviewRepo);
        Category testCategory = new Category("Sedan");
        Hashtag testHashtag = new Hashtag("yay");
        testReview = new Review(testCategory, "I Hate This Car", "Good");


    }

    @Test
    public void shouldFindReviewById(){
        when(reviewRepo.findById(1L)).thenReturn(Optional.of(testReview));
        Review retrievedReview = underTest.findReviewById(1L);
        assertThat(retrievedReview).isEqualTo(testReview);

    }

    @Test
    public void shouldStoreReview(){
        underTest.store(testReview);
        verify(reviewRepo).save(testReview);
    }
}
