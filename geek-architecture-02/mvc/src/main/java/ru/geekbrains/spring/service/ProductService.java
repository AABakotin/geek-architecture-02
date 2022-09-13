package ru.geekbrains.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.dto.ProductDto;
import ru.geekbrains.spring.entities.Product;
import ru.geekbrains.spring.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(ProductDto productDto) {
        Product product = productRepository.findByName(productDto.getTitle());
        if (product == null)
            throw new IllegalStateException("product not found with name " + productDto.getTitle());

        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }
}
