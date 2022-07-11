package com.danmag.pcpartsstore.service.service;

import com.danmag.pcpartsstore.service.dto.ProductDto;
import com.danmag.pcpartsstore.service.model.Product;
import com.danmag.pcpartsstore.service.repository.CategoryRepository;
import com.danmag.pcpartsstore.service.repository.OrderItemRepository;
import com.danmag.pcpartsstore.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(OrderItemRepository orderItemRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Product getProductFromDto(ProductDto productDto) {
        Product product = new Product(productDto);
        return product;
    }

    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public Product getById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public void updateProduct(long id, ProductDto productDto) throws Exception {
        Product product = getProductFromDto(productDto);
        product.setId(id);
        productRepository.save(product);
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    public void deleteProduct(long id) {

        productRepository.deleteById(id);
    }


}
