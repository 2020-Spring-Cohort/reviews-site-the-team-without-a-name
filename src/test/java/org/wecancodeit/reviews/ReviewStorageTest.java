package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewStorageTest {

    @Test
    public void ReviewStorageTest() {
        Review testReview = new Review("Sedan");
        ReviewStorage underTest = new MapReviewStorage();
        underTest.store(testReview);
        assertThat(underTest.findAllReviews()).contains(testReview);
    }

    @Test
    public void shouldRetrieveSingleReviewByCategory(){
        Review testReview1 = new Review("Sedan");
        Review testReview2 = new Review("Coupe");
        ReviewStorage underTest = new MapReviewStorage();
        underTest.store(testReview1);
        underTest.store(testReview2);
        Review retrieveReview1 = underTest.findReviewByCategory("Sedan");
        Review retrieveReview2 = underTest.findReviewByCategory("Coupe");
        assertThat(retrieveReview1).isEqualTo(testReview1);
        assertThat(retrieveReview2).isEqualTo(testReview2);

    }
}
