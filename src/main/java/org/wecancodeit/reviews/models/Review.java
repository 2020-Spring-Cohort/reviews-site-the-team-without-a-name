package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

import java.util.*;

@Entity
public class Review {
    @Lob
    private  String reviewBody;
    private  String title;
    @ManyToOne
    private Category category;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany
    private Collection<Comment> comments;
    public Review(Category category, String title, String reviewBody, Hashtag...hashtag ){

         this.category = category;
         this.title = title;
         this.reviewBody = reviewBody;
         this.hashtags= Arrays.asList(hashtag);
    }
    public Review(){

    }
    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Collection<Comment> getComments(){
        return comments;
    }

    public void addCommentToReview(Comment commentToAdd){
        comments.add(commentToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return Objects.equals(reviewBody, review.reviewBody) &&
                Objects.equals(title, review.title) &&
                Objects.equals(category, review.category) &&
                getId().equals(review.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewBody, title, category, getId());
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }
}
