package com.bansikah.ecommerce;

import com.bansikah.ecommerce.controller.ProductController;
import com.bansikah.ecommerce.domain.Product;
import com.bansikah.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ECommerceApplication.class)
@WebAppConfiguration
public class ProductControllerTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testList() {
        List<Product> products = productService.getAllProducts();
        System.out.println(products);
    }

    @Test
    public void testGetProductById() {
        Product product = productService.getProductById(1L);
        System.out.println(product);
    }

    @Test
    public void testSave() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(10.0);
        productService.createProduct(product);
    }
}
