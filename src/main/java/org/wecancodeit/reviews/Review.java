package org.wecancodeit.reviews;

import java.util.Objects;

public class Review {
    private String category;

    public Review(String category){

         this.category = category;
    }

    public String getCategory(){
        return category;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(category, review.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }


}
