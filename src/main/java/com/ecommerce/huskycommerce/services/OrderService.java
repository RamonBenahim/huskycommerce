package com.ecommerce.huskycommerce.services;

import com.ecommerce.huskycommerce.dto.OrderDTO;
import com.ecommerce.huskycommerce.dto.ProductDTO;
import com.ecommerce.huskycommerce.entities.Order;
import com.ecommerce.huskycommerce.entities.Product;
import com.ecommerce.huskycommerce.repositories.OrderRepository;
import com.ecommerce.huskycommerce.repositories.ProductRepository;
import com.ecommerce.huskycommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;
  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Resource not found."));
    return new OrderDTO(order);
  }
}
