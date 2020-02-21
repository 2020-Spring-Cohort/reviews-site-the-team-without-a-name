package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;
@Entity
public class Hashtag {

    private String hashtag;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "hashtag")
    private Collection<Review> reviews;

    public Hashtag(){

    }

    public Hashtag(String anything) {
        this.hashtag = anything;
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
