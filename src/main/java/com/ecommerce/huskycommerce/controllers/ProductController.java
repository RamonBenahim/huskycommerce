package com.ecommerce.huskycommerce.controllers;

import com.ecommerce.huskycommerce.dto.ProductDTO;
import com.ecommerce.huskycommerce.entities.Product;
import com.ecommerce.huskycommerce.repositories.ProductRepository;
import com.ecommerce.huskycommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping(value = "/{id}")
  public ProductDTO findById(@PathVariable Long id) {
    return service.findById(id);
  };
}
