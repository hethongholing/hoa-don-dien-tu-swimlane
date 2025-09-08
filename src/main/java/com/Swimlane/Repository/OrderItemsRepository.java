package com.Swimlane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Swimlane.Entity.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, String> {

}
