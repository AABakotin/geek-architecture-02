package ru.geekbrains.spring.converter;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.dto.ProductDto;
import ru.geekbrains.spring.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public List<ProductDto> entityToDto(List<Product> products){

        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p: products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(p.getId());
            productDto.setTitle(p.getTitle());
            productDto.setPrice(p.getPrice());
            productDtoList.add(productDto);
        }

        return productDtoList;

    }
}
