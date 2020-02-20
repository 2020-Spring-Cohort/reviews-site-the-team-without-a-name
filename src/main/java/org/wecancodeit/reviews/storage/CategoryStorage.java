package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;

import java.util.Collection;

public interface CategoryStorage {


    public Collection<Category> findAllCategories();



    public void store(Category category);




    public Category findCategoryByType(String categoryType);



}
