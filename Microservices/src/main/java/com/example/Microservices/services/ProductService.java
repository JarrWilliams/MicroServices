package com.example.Microservices.services;

import com.example.Microservices.model.Product;
import com.example.Microservices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public Page<Product> findProductsWithPagination(int offset, int pageSize){
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Product> products = productRepository.findAll(pageable);

        return products;
    }
    public void createNewProduct(Product product){
        Optional<Product> productByName = productRepository.findProductByName(product.getName());
        if (productByName.isPresent()){
            throw new IllegalStateException("Product name already in use");
        }
        productRepository.save(product);
    }
    public Optional<Product> findProductDetailsById(Long productId){
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("Product with id " + productId + " does not exist");
        }
        return productRepository.findById(productId);
    }
    public String updateProductDetails(Product product){
        Product newProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalStateException("Product not found"));
        Optional<Product> optionalProduct = productRepository.findProductByName(product.getName());
        if (optionalProduct.isPresent() && !Objects.equals(product.getName(),newProduct.getName())){
            throw new IllegalStateException("Name already taken");
        }
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantityAvailable(product.getQuantityAvailable());
        productRepository.save(newProduct);
        return "Success";
    }
}
