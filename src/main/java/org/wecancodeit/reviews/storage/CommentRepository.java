package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.models.Hashtag;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {


}
