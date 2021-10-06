package com.arrisdev.productservice.controller;

import com.arrisdev.productservice.model.Product;
import com.arrisdev.productservice.model.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**developed by
 * arris manduma
 * on 10/6/2021
 */

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }


}
