package org.wecancodeit.reviews;

import java.util.Collection;

public interface ReviewStorage {


    public Collection<Review> findAllReviews();



    public void store(Review review);




    public Review findReviewByCategory(String reviewCategory);



}
