package com.danmag.pcpartsstore.service.controller;

import com.danmag.pcpartsstore.service.api.ApiResponse;
import com.danmag.pcpartsstore.service.dto.ProductDto;
import com.danmag.pcpartsstore.service.model.Category;
import com.danmag.pcpartsstore.service.model.Product;
import com.danmag.pcpartsstore.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllEntities() {
        List<ProductDto> body = productService.getAll();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        var Product = productService.getById(id);
        return new ResponseEntity<Product>(Product, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) throws Exception {
        productService.updateProduct(id, productDto);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) throws Exception {

        productService.addProduct(product);
        return new ResponseEntity<>("Product has been added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been deleted"), HttpStatus.OK);
    }


}
