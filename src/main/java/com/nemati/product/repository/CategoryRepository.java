package com.nemati.product.repository;

import com.nemati.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryName(String name);
}
