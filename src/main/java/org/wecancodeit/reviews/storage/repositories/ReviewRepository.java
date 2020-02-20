package org.wecancodeit.reviews.storage.repositories;

import org.wecancodeit.reviews.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {

}
