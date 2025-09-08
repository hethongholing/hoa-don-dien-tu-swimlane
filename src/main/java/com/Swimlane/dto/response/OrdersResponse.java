package com.Swimlane.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersResponse {
	private String merchantOrderId;
    private String customerName;
    private String customerTaxCode;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal vatPct;
    private BigDecimal total;
    private String status;
    private List<OrderItemsResponse> items;
}
