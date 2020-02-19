package org.wecancodeit.reviews;

import java.util.Objects;

public class Review {
    private final String reviewBody;
    private final String title;
    private String type;

    public Review(String type, String title, String reviewBody){

         this.type = type;
         this.title = title;
         this.reviewBody = reviewBody;
    }

    public String getType(){
        return type;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(type, review.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }


}
