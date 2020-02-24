package org.wecancodeit.reviews.storage;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;


import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class    CategoryStorageJpaImpTest {


    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory = new Category("Sedan");
        CategoryStorage underTest = new CategoryStorageJpaImp(mockCategoryRepo);
        when(mockCategoryRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.store(testCategory);
        verify(mockCategoryRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);


    }

    @Test
    public void shouldretrieveSingleCategoryByType(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testcategory1 = new Category("Sedan");
        Category testcategory2 = new Category("Coupe");
        CategoryStorage underTest = new CategoryStorageJpaImp(mockCategoryRepo);
        underTest.store(testcategory1);
        underTest.store(testcategory2);
        Optional<Category> testCategory1Optional = Optional.of(testcategory1);
        when(mockCategoryRepo.findByType("Sedan")).thenReturn(testCategory1Optional);

        Optional<Category> testCategory2Optional = Optional.of(testcategory2);
        when(mockCategoryRepo.findByType("Coupe")).thenReturn(testCategory2Optional);

        Category retrievedCategory1 = underTest.findCategoryByType("Sedan");
        Category retrievedCategory2 = underTest.findCategoryByType("Coupe");
        assertThat(retrievedCategory1).isEqualTo(testcategory1);
        assertThat(retrievedCategory2).isEqualTo(testcategory2);
    }

}
