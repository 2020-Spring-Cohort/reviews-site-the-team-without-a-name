package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.storage.repositories.CommentRepository;

import java.util.Collection;

public class CommentStorageJpaImpl {
    @Service
    public class CommentStorageJpaImp implements CommentStorage {
        private CommentRepository commentRepository;

        public CommentStorageJpaImp(CommentRepository commentRepo) {
            this.commentRepository = commentRepo;
        }

        @Override
        public Comment findCommentById(Long id) {
            return commentRepository.findById(id).get();
        }

        @Override
        public void store(Comment commentToStore){
            commentRepository.save(commentToStore);
        }

        @Override
        public Collection<Comment> findAllComments(){
            return (Collection<Comment>) commentRepository.findAll();
        }

    }

}
