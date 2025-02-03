package org.crystalkste.myshop.repository;

import org.crystalkste.myshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
