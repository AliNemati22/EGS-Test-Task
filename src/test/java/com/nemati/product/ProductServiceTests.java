package com.nemati.product;

import com.nemati.product.model.Category;
import com.nemati.product.model.Product;
import com.nemati.product.repository.ProductRepository;
import com.nemati.product.service.CategoryService;
import com.nemati.product.service.ProductService;
import com.nemati.product.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryService categoryService;

    @Mock
    private UserService userService;

    @Test
    public void getProductById() {
        ProductService productService = new ProductService(productRepository, categoryService, userService);
        Product product = new Product();
        product.setId(1);
        product.setName("Test");
        product.setPrice(100F);
        product.setQuantity(3);
        Category category = new Category();
        category.setCategoryName("TestCategory");
        product.setCategory(category);

        productRepository.save(product);

        when(productRepository.findById(1).get()).thenReturn(product);

        Product product1 = productService.getProductById(1);
        assertThat(product1).isEqualTo(product);
    }
}
