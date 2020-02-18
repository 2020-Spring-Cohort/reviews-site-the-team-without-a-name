package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryStorageTest {

    @Test
    public void ReviewStorageTest() {
        Category testCategory = new Category("Sedan");
        CategoryStorage underTest = new MapCategoryStorage();
        underTest.store(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }

    @Test
    public void shouldRetrieveSingleReviewByCategory(){
        Category testCategory1 = new Category("Sedan");
        Category testCategory2 = new Category("Coupe");
        CategoryStorage underTest =
                new MapCategoryStorage();
        underTest.store(testCategory1);
        underTest.store(testCategory2);
        Category retrieveCategory1 = underTest.findCategoryByType("Sedan");
        Category retrieveCategory2 = underTest.findCategoryByType("Coupe");
        assertThat(retrieveCategory1).isEqualTo(testCategory1);
        assertThat(retrieveCategory2).isEqualTo(testCategory2);

    }
}
