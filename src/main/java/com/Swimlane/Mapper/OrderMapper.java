package com.Swimlane.Mapper;

import java.util.List;
import java.time.LocalDateTime;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.Swimlane.Entity.OrderItems;
import com.Swimlane.Entity.Orders;
import com.Swimlane.dto.response.OrderItemsResponse;
import com.Swimlane.dto.response.OrdersResponse;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "rawPayload", ignore = true)
    @Mapping(target = "items", source = "items")
    Orders toOrders(OrdersResponse ordersResponse);
	
	@Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true) // sẽ set lại sau
    OrderItems toEntity(OrderItemsResponse dto);

    List<OrderItems> toEntityList(List<OrderItemsResponse> items);
}
