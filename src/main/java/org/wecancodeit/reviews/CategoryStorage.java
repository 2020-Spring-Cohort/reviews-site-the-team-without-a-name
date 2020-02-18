package org.wecancodeit.reviews;

import java.util.Collection;

public interface CategoryStorage {


    public Collection<Category> findAllCategories();



    public void store(Category category);




    public Category findCategoryByType(String categoryType);



}
