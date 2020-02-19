package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categorySHouldHaveAListOfReviews(){
        Category testCategory = new Category("Sedan");
        Review testReview = new Review("Sedan","positive","this is awesome");
        categoryRepo.save(testCategory);


    }



}
