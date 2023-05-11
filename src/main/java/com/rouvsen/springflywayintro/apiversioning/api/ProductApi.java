package com.rouvsen.springflywayintro.apiversioning.api;

import com.rouvsen.springflywayintro.apiversioning.dto.ProductV1;
import com.rouvsen.springflywayintro.apiversioning.dto.ProductV2;
import com.rouvsen.springflywayintro.apiversioning.entity.Product;
import com.rouvsen.springflywayintro.apiversioning.repo.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProductApi {

    private final ProductRepository productRepository;

    public ProductApi(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/v1/product")
    public ResponseEntity<ProductV1> saveProductV1(@RequestBody ProductV1 productV1) {
        Product product = new Product(productV1.getId(), productV1.getName());
        Product saved = productRepository.save(product);
        return ResponseEntity.of(Optional.of(new ProductV1(saved.getId(), saved.getName())));
    }

    //URI Versioning
    @GetMapping(value = "/v1/product")
    public ResponseEntity<List<ProductV1>> pathVersioningProductV1() {
        List<Product> all = productRepository.findAll();
        List<ProductV1> allV1 = new ArrayList<>();
        for (Product product : all) {
            allV1.add(new ProductV1(
                    product.getId(),
                    product.getName())
            );
        }
        return ResponseEntity.of(Optional.of(allV1));
    }
    @GetMapping(value = "/v2/product")
    public ResponseEntity<List<ProductV2>> pathVersioningProductV2() {
        List<Product> all = productRepository.findAll();
        List<ProductV2> allV2 = new ArrayList<>();
        for (Product product : all) {
            allV2.add(new ProductV2(
                    product.getId(),
                    product.getName(),
                    product.getPrice())
            );
        }
        return ResponseEntity.of(Optional.of(allV2));
    }

    //Path Versioning
    //http://localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
    }
    //http://localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
    }

    //Header Versioning (Request Header)
    //http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
    }
    //http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
    }
}
