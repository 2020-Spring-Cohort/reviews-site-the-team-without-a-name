package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;


@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage){
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/hashtags")
    public String displayHashtag(Model model){
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "hashtags-view";

    }

@RequestMapping("/hashtags/{id}")
    public String displayHashtag(@PathVariable Long id, Model model) {
        Hashtag retrievedHashtag = hashtagStorage.findHashtagById(id);
        model.addAttribute("hashtag",retrievedHashtag);
        return "hashtag-view";
    }
}
