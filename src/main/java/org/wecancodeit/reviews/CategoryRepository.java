package org.wecancodeit.reviews;

public interface CategoryRepository {

   Optional<Category> findByType(String categoryType);
}
