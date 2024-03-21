package com.ecommerce.huskycommerce.repositories;

import java.util.List;
import java.util.Optional;

import com.ecommerce.huskycommerce.entities.Order;
import com.ecommerce.huskycommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.huskycommerce.entities.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
