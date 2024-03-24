package com.ecommerce.huskycommerce.repositories;

import com.ecommerce.huskycommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
