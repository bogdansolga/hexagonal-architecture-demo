package com.cerner.hexagonal.architecture.demo.order.domain.repository;

import com.cerner.hexagonal.architecture.demo.order.domain.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
