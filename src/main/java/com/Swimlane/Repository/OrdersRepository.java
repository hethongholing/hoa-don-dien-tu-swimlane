package com.Swimlane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Swimlane.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

}
