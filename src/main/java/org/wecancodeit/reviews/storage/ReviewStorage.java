package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Review;

public interface ReviewStorage {
   Review findReviewById(long id);

   void store(Review reviewToStore);
}
