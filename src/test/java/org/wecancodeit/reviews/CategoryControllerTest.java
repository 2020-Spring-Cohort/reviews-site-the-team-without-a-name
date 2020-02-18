package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoryController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneReview(){
        Review testReview = new Review("Car");
        when(mockStorage.findReviewByCategory("Sedan")).thenReturn(testReview);

        underTest.displaySingleReview("Sedan", mockModel);

        verify(mockStorage).findReviewByCategory("Sedan");
        verify(mockModel).addAttribute("category", testReview);

    }
    @Test
    public void shouldRetrunViewNamedReviewWhenDisplayedSingleCategoryIsCalled(){
        String viewName = underTest.displaySingleReview("Coupe", mockModel);
        assertThat(viewName).isEqualTo("reviewView");
    }
    @Test
    public void shouldGoToIndividualEndPoint() throws Exception{
        Review testReview = new Review("coupe");
        when(mockStorage.findReviewByCategory("coupe")).thenReturn(testReview);

        mockMvc.perform(get("/category/coupe"))
                .andExpect(status().isOk())
                .andExpect(view().name("reviewView"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category",testReview));
    }
}


