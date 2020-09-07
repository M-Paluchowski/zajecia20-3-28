package com.example.demo.examples.springdata.controller;

import com.example.demo.examples.springdata.model.Product;
import com.example.demo.examples.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Product> main() {
//        return productRepository.getProductsWithName("Komputer");
//        return productRepository.getProductsWithNameAndPrice("Ko", 1999.99);
        productRepository.deleteProductWithNameLike("Ko");
        return productRepository.getProductsWithNameAndPriceNative("Ko", 1999.99);
    }
}
