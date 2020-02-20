package org.wecancodeit.reviews.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;


@Service
public class ReviewStorageJpaImp implements ReviewStorage {
    private ReviewRepository reviewRepository;

    public ReviewStorageJpaImp(ReviewRepository reviewRepo) {
        this.reviewRepository = reviewRepo;
    }

    @Override
    public Review findReviewById(long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void store(Review reviewToStore){
        reviewRepository.save(reviewToStore);
    }
}
