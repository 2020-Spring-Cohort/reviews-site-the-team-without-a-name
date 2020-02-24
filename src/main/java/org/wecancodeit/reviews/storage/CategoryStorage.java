package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;

import java.util.Collection;

public interface CategoryStorage {


    Collection<Category> findAllCategories();



    void store(Category category);




    Category findCategoryByType(String categoryType);



}
