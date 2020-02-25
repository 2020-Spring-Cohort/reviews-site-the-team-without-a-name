package org.wecancodeit.reviews.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
    public class Comment {
@ManyToOne
        private Review review;
        private String comment;


        @Id
        @GeneratedValue
        private Long id;

        public Comment() {

        }

        public Comment(String comment, Review review) {
            this.comment = comment;
            this.review = review;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(review, comment1.review) &&
                Objects.equals(comment, comment1.comment) &&
                Objects.equals(id, comment1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review, comment, id);
    }

    public String getComment() {
        return comment;
    }

    public Long getId() {
        return id;
    }
}

