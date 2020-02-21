package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.storage.CategoryStorage;

@Component
    public class CategoryPopulator implements CommandLineRunner {

        CategoryStorage categoryStorage;

        public CategoryPopulator(CategoryStorage categoryStorage){
            this.categoryStorage = categoryStorage;
        }
        @Override
        public void run(String... args) throws Exception {
            categoryStorage.store(new Category("Sedan"));
            categoryStorage.store(new Category("Coupe"));

        }
}
