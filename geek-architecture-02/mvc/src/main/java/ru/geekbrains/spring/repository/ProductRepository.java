package ru.geekbrains.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
    @Query(value = "SELECT * FROM products p WHERE p.title = ?", nativeQuery = true)
    Product findByName(String title);
}
