package com.bansikah.ecommerce;

import com.bansikah.ecommerce.domain.Product;
import com.bansikah.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner .class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void SaveProduct_to_repository() {
        //Arrange
        Product product =
        Product.builder().id(1L).name("Product 1")
                .description("Product 1 description")
                .price(100.0)
                .build();
        System.out.println("ProductRepository instance: " + productRepository);
        //Act
       Product savedProduct = productRepository.save(product);

        //Assert
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);

        System.out.println("Saved Product: " + savedProduct);
    }

    @Test
    public void productRepository_getAllProducts() {
        //Arrange
        Product product =
                Product.builder().id(1L).name("Product 1")
                        .description("Product 1 description")
                        .price(100.0)
                        .build();
        Product savedProduct = productRepository.save(product);

        Product product2 =
                Product.builder().id(1L).name("Product 1")
                        .description("Product 1 description")
                        .price(100.0)
                        .build();
        Product saveProduct =  productRepository.save(product2);

        System.out.println("ProductRepository instance: " + productRepository);

        //Act
        List<Product> products = productRepository.findAll();

        //Assert
        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isGreaterThan(0);

        System.out.println("Products: " + products);
    }

}
