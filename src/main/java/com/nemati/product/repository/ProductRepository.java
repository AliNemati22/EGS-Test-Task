package com.nemati.product.repository;

import com.nemati.product.model.Product;
import com.nemati.product.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByUser(User user);
}
