package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api")
    public static class ProductController {

        private final ProductService productService;

        @PostMapping("/products")
        public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
            return productService.createProduct(productRequestDto);
        }

        @PutMapping("/products/{id}")
        public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto mypriceRequestDto) {
            return productService.updateProduct(id, mypriceRequestDto);
        }

        @GetMapping("/products")
        public List<ProductResponseDto> getProducts() {
            return productService.products();
        }
    }
}