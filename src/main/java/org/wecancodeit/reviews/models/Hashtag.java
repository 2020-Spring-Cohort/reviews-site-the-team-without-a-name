package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
@Entity
public class Hashtag {

    private String hashtag;

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> reviews;

    public String getHashtag() {
        return hashtag;
    }

    protected Hashtag(){

    }

    public Hashtag(String hashtag) {
        reviews = new ArrayList<>();
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtag)) return false;
        Hashtag hashtag1 = (Hashtag) o;
        return Objects.equals(hashtag, hashtag1.hashtag) &&
                Objects.equals(id, hashtag1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashtag, id);
    }
}
