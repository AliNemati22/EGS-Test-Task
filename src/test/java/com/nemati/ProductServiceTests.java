//package com.nemati;
//
//import com.nemati.model.Product;
//import com.nemati.model.ProductCategory;
//import com.nemati.model.dto.ProductDTO;
//import com.nemati.repository.ProductRepository;
//import com.nemati.service.ProductCategoryQueryService;
//import com.nemati.service.ProductService;
//import com.nemati.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Java6Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//public class ProductServiceTests {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @Mock
//    private CategoryService categoryService;
//
//    @Mock
//    private UserService userService;
//
//    @Test
//    public void getProductById() {
//        ProductService productService = new ProductService(productRepository, categoryService, userService);
//        ProductDTO product = new ProductDTO();
//        product.setId(1l);
//        product.setProductName("Test");
//        product.setTotalPrice(100F);
//        product.setCount(3);
//        ProductCategory category = new ProductCategory();
//        category.setCategoryName("TestCategory");
//
//        productRepository.save(product);
//
//        when(productRepository.findById(1l).get()).thenReturn(product);
//
//        Optional<ProductDTO> one = productService.findOne(1l);
//        assertThat(one.get()).isEqualTo(product);
//    }
//}
