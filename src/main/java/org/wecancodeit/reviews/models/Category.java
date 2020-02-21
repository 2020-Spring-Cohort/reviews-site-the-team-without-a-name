package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;

    public Category(String type){

        this.type = type;

    }
    public Category(){

    }
    public String getType(){
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return getId().equals(category.getId()) &&
                Objects.equals(getType(), category.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType());
    }

    public Long getId() {
        return id;
    }

    public Collection<Review> getReviews() {
        return reviews;

    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
