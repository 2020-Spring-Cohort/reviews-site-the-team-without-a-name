package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.models.Hashtag;

import java.util.Collection;

public interface CommentStorage {

    void store(Comment commentToStore);

    Comment findCommentById(Long id);

    Collection<Comment> findAllComments();
}


