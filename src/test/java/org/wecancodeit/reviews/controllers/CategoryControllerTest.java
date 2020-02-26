package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Collections;
import java.util.List;

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
    private CategoryRepository mockStorage2;
    private ReviewRepository mockStorage3;


    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        mockStorage2 = mock(CategoryRepository.class);
        mockStorage3 = mock(ReviewRepository.class);
        underTest = new CategoryController(mockStorage,mockStorage2,mockStorage3);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneReview() {
        Category testCategory = new Category("Car");
        when(mockStorage.findCategoryByType("Sedan")).thenReturn(testCategory);

        underTest.displaySingleCategory("Sedan", mockModel);

        verify(mockStorage).findCategoryByType("Sedan");
        verify(mockModel).addAttribute("category", testCategory);

    }

    @Test
    public void shouldReturnViewNamedCatergoryWhenDisplayedSingleCategoryIsCalled() {
        String viewName = underTest.displaySingleCategory("Coupe", mockModel);
        assertThat(viewName).isEqualTo("category-view");
    }

    @Test
    public void shouldGoToIndividualEndPoint() throws Exception {
        Category testCategory = new Category("coupe");
        when(mockStorage.findCategoryByType("coupe")).thenReturn(testCategory);

        mockMvc.perform(get("/categories/coupe"))
                .andExpect(status().isOk())
                .andExpect(view().name("category-view"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", testCategory));
    }

    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("coupe");

        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categories-view"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}


