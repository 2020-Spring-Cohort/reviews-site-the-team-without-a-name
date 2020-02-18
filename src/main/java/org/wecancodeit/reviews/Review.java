package org.wecancodeit.reviews;

import java.util.Objects;

public class Review {
    private String type;

    public Review(String type){

         this.type = type;
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
