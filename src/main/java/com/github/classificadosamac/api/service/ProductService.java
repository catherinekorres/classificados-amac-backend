package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.dto.ProductDTO;
import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductService {
    // Singleton
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO save(Product product) {
        productRepository.save(product);

        return new ProductDTO(productRepository.save(product));
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);

        return products.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product product) {

                return new ProductDTO(product);
            }
        });
    }

    public Optional<ProductDTO> findOne(Long id) {
        Optional<Product> product = productRepository.findById(id);

        return product.map(ProductDTO::new);
    }

    public ProductDTO update(Product product, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            return null;
        }

        product.setId(id);

        return this.save(product);
    }

    public void delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
        }
    }
}
