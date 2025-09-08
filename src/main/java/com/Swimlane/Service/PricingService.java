package com.Swimlane.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.Swimlane.Entity.Orders;

@Service
public class PricingService {

	public BigDecimal applyPromotions(Orders order, String code) {
        if ("SALE10".equals(code)) {
            return order.getTotal().multiply(BigDecimal.valueOf(0.9));
        }
        return order.getTotal();
    }
}
