package org.wecancodeit.reviews.storage.repositories;


import org.wecancodeit.reviews.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

   Optional<Category> findByType(String categoryType);



}
