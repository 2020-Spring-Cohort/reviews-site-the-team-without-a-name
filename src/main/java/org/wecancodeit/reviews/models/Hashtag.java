package org.wecancodeit.reviews.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Hashtag {

    private String Hashtag;
    @Id
    @GeneratedValue
    private Long id;



    public Hashtag(){ }


    public Hashtag(String anything) {
        this.Hashtag = anything;
    }
}
