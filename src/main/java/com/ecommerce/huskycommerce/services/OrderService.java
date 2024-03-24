package com.ecommerce.huskycommerce.services;

import com.ecommerce.huskycommerce.dto.OrderDTO;
import com.ecommerce.huskycommerce.dto.OrderItemDTO;
import com.ecommerce.huskycommerce.entities.*;
import com.ecommerce.huskycommerce.repositories.OrderItemRepository;
import com.ecommerce.huskycommerce.repositories.OrderRepository;
import com.ecommerce.huskycommerce.repositories.ProductRepository;
import com.ecommerce.huskycommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Autowired
  private AuthService authService;

  @Autowired
  private UserService userService;

  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Resource not found."));
    authService.validateSelfOrAdmin(order.getClient().getId());
    return new OrderDTO(order);
  }

  @Transactional
  public OrderDTO insert(OrderDTO dto) {
    Order order = new Order();

    order.setMoment(Instant.now());
    order.setStatus(OrderStatus.WAITING_PAYMENT);
    User user = userService.authenticated();
    order.setClient(user);

    for (OrderItemDTO itemDto : dto.getItems()) {
      Product product = productRepository.getReferenceById(itemDto.getProductId());
      OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
      order.getItems().add(item);
    }

    repository.save(order);
    orderItemRepository.saveAll(order.getItems());

    return new OrderDTO(order);
  };
}
