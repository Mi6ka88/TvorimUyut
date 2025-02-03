package org.crystalkste.myshop.service;

import org.crystalkste.myshop.entity.Product;
import org.crystalkste.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Product updateProductCategory(Long id, String categoryName) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setCategoryName(categoryName);
            return productRepository.save(product);
        }
        return null;
    }

    public List<Product> getProductsByCategoryAndId(String categoryName, Long id) {
        return productRepository.findByCategoryNameAndId(categoryName, id);
    }
}