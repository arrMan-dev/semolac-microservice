package com.arrisdev.productservice.model;

import com.arrisdev.productservice.repository.ProductRepository;
import com.arrisdev.productservice.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**developed by
 * arris manduma
 * on 10/6/2021
 */

@Service
@Slf4j
public class ProductService implements ProductServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //save product
    public Product saveProduct(Product product){
        log.info("Saving product in the product service: {}", product);
        product.setCreatedTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    //delete product
    public void deleteProduct(Long id){
        log.info("Deleting product in the product service: {}", id);
        productRepository.deleteById(id);
    }

    //list all product
    public List<Product> findAllProducts(){
        log.info("Fetching all products in the product service: {}");
        return productRepository.findAll();
    }
}
