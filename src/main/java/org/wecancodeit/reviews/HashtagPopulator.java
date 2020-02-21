package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;

@Component
public class HashtagPopulator implements CommandLineRunner {

    HashtagStorage hashtagStorage;

    public HashtagPopulator(HashtagStorage hashtagStorage){
        this.hashtagStorage = hashtagStorage;
    }
    @Override
    public void run(String... args) throws Exception {
        hashtagStorage.store(new Hashtag("holyshit"));
        hashtagStorage.store(new Hashtag("thisworks"));

    }
}