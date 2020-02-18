package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapCategoryStorage implements CategoryStorage {
    private HashMap<String, Category> categories;

    public MapCategoryStorage(){
        categories = new HashMap<>();
    }

    @Override
    public Collection<Category> findAllCategories(){
        return categories.values();
    }

    @Override
    public void store(Category category){
        categories.put(category.getType(), category);
    }

    @Override
    public Category findCategoryByType(String categoryType){
        return categories.get(categoryType);
    }




}
