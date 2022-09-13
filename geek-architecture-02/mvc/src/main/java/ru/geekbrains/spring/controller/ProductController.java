package ru.geekbrains.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.converter.ProductConverter;
import ru.geekbrains.spring.dto.ProductDto;
import ru.geekbrains.spring.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> getAllProductDto() {
        return productConverter.entityToDto(productService.findAllProduct());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
    }
}
