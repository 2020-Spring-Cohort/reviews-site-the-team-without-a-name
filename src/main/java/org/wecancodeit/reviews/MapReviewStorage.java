package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapReviewStorage implements ReviewStorage {
    private HashMap<String, Review> reviews;

    public MapReviewStorage(){
        reviews = new HashMap<>();
    }

    @Override
    public Collection<Review> findAllReviews(){
        return reviews.values();
    }

    @Override
    public void store(Review review){
        reviews.put(review.getCategory(), review);
    }

    @Override
    public Review findReviewByCategory(String reviewCategory){
        return reviews.get(reviewCategory);
    }




}
