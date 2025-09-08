package com.Swimlane.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "swimlane_orders")
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
	
	@Column(name = "merchant_order_id", nullable = false, length = 100)
    private String merchantOrderId;

    @Column(name = "customer_name", length = 255)
    private String customerName;

    @Column(name = "customer_tax_code", length = 50)
    private String customerTaxCode;

    private BigDecimal subtotal;
    
    private BigDecimal discount;

    @Column(name = "vat_pct")
    private BigDecimal vatPct;

    private BigDecimal total;

    @Column(length = 50)
    private String status;

    @Lob
    @Column(name = "raw_payload")
    private String rawPayload;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> items;
}
