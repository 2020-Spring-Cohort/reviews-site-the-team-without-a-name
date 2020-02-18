package org.wecancodeit.reviews;

import java.util.Collection;

public interface CategoryStorage {


    public Collection<Review> findAllCategories();



    public void store(Category category);




    public Review findCategoryByType(String categoryType);



}
