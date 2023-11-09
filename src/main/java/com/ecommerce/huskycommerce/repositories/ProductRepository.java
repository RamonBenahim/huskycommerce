package com.ecommerce.huskycommerce.repositories;

import com.ecommerce.huskycommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
