package org.wecancodeit.reviews.storage;


import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;

@Service
public class HashtagStorageJpaImp implements HashtagStorage {
    private HashtagRepository hashtagRepository;


    public HashtagStorageJpaImp(HashtagRepository hashtagRepository){
        this.hashtagRepository = hashtagRepository;
    }
    @Override
    public void store(Hashtag hashtagToStore){
        hashtagRepository.save(hashtagToStore);

    }
    @Override
    public Hashtag findHashtagById(Long id){
        return hashtagRepository.findById(id).get();
    }

}
