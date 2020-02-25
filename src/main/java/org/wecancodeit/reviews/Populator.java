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
        Hashtag hashtag1 = new Hashtag("TotallyWorthIt");
        Hashtag hashtag2 = new Hashtag("HolyCow");
        hashtagStorage.store(hashtag1);
        hashtagStorage.store(hashtag2);
        Review review1 = new Review(sedan, "Viagra on wheels", "Absolutely amazing car. Very quick, great " +
                "styling, and really makes a statement when I come to a stop at a red light. " +
                "This car is like Viagra on wheels", hashtag1);
        Review review2 = new Review(coupe, "Holy Cow!!!!", "I got a really great deal on this car, " +
                "so I didn't expect it to loose that much. The KBB rating is less than half what the MSRP was, " +
                "and about 50% of what I paid. Other than that, I have had a few problems with it. Driver power window," +
                " which they \"couldn't find the problem with it\" the two times I had it in for service. Finally," +
                " the window totally came out of the frame on a rainy night. The electronics are, well, not that good. " +
                "Navigation and voice recognition are the worst. I do like the performance and " +
                "handling, but the biggest rush of adrenaline I got was seeing" +
                " how far upside down I was, even at 0% financing!" , hashtag2);
        reviewStorage.store(review1);
        reviewStorage.store(review2);

        
    }
}
