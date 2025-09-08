package com.Swimlane.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsResponse {
	private String sku;
    private String name;
    private Integer qty;
    private BigDecimal unitPrice;
    private BigDecimal discountPct;
}
