package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


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
        Review testReview = new Review(testCategory,"positive","this is awesome");
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview);

        entityManager.flush();
        entityManager.clear();
        Optional<Category> retrievedCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();
        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();

        assertThat(retrievedCategory.getReviews()).contains(testReview);




    }



}
