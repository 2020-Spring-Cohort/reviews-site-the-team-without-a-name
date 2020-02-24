package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;



@Component
public class Populator implements CommandLineRunner{

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;
    private HashtagStorage hashtagStorage;

    public Populator(ReviewStorage reviewStorage, CategoryStorage categoryStorage, HashtagStorage hashtagStorage){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args){
        Category sedan = new Category("Sedan");
        categoryStorage.store(sedan);
        Category coupe = new Category("Coupe");
        categoryStorage.store(coupe);
        Review review1 = new Review(sedan, "Review", "Body");
        Review review2 = new Review(coupe, "Review", "Body");
        reviewStorage.store(review1);
        reviewStorage.store(review2);
        hashtagStorage.store(new Hashtag("holyshit"));
        hashtagStorage.store(new Hashtag("thisworks"));
        
    }
}
