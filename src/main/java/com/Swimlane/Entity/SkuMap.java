package com.Swimlane.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "swimlane_sku_map")
public class SkuMap {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
	
	@Column(name = "merchant_sku")
    private String merchantSku;

    @Column(name = "analy_sku")
    private String analySku;

    @Column(name = "vat_pct")
    private BigDecimal vatPct;

    @Column(name = "price_policy_id")
    private Long pricePolicyId;
}
