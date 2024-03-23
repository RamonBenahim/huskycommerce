package com.ecommerce.huskycommerce.repositories;
import com.ecommerce.huskycommerce.entities.OrderItem;
import com.ecommerce.huskycommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

