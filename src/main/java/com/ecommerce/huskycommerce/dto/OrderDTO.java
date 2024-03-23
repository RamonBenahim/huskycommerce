package com.ecommerce.huskycommerce.dto;

import com.ecommerce.huskycommerce.entities.Order;
import com.ecommerce.huskycommerce.entities.OrderItem;
import com.ecommerce.huskycommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

  private Long id;
  private Instant moment;
  private OrderStatus status;
  private ClientDTO user;
  private PaymentDTO payment;

  @NotEmpty(message = "O Pedido deve ter pelo menos um produto.")
  private List<OrderItemDTO> items = new ArrayList<>();

  public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO user, PaymentDTO payment) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.user = user;
    this.payment = payment;
  }

  public OrderDTO(Order entity) {
    id = entity.getId();
    moment = entity.getMoment();
    status = entity.getStatus();
    user = new ClientDTO(entity.getClient());
    payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());

    for(OrderItem item : entity.getItems()) {
      items.add(new OrderItemDTO(item));
    }
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public ClientDTO getUser() {
    return user;
  }

  public PaymentDTO getPayment() {
    return payment;
  }

  public List<OrderItemDTO> getItems() {
    return items;
  }

  public Double getTotal() {
    double sum = 0.0;
    for(OrderItemDTO item : items) {
      sum += item.getSubTotal();
    }
    return sum;
  }
}
