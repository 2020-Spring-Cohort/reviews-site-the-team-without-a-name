package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);

    Hashtag findHashtagById(Long id);

    Collection<Hashtag> findAllHashtags();
}
