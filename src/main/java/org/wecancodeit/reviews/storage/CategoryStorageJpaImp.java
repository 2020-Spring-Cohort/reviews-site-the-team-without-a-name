package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryStorageJpaImp implements CategoryStorage {
    private final CategoryRepository categoryRepository;

    public CategoryStorageJpaImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Collection<Category> findAllCategories(){
        return (Collection<Category>) categoryRepository.findAll();
    }


    @Override
    public void store(Category category){
        categoryRepository.save(category);
    }



    @Override
    public Category findCategoryByType(String categoryType){
        Category retrievedCategory;
        try{
            retrievedCategory = categoryRepository.findByType(categoryType).get();
        } catch (Exception e){
            throw new CategoryNotFoundException(e.getMessage());
        }

        return retrievedCategory;



    }



}

