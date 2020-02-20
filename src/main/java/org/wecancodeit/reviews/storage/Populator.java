package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
    public class Populator implements CommandLineRunner {

        CategoryStorage categoryStorage;

        public Populator(CategoryStorage categoryStorage){
            this.categoryStorage = categoryStorage;
        }
        @Override
        public void run(String... args) throws Exception {
            categoryStorage.store(new Category("Sedan"));
            categoryStorage.store(new Category("Coupe"));

        }
}
