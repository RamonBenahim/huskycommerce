package com.ecommerce.huskycommerce.dto;

import com.ecommerce.huskycommerce.entities.Payment;

public class PaymentDTO {
  private Long id;
  private String moment;

  public PaymentDTO(Long id, String moment) {
    this.id = id;
    this.moment = moment;
  }

  public PaymentDTO(Payment entity) {
    id = entity.getId();
    moment = entity.getMoment().toString();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMoment() {
    return moment;
  }

  public void setMoment(String moment) {
    this.moment = moment;
  }
}
