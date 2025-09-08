package com.Swimlane.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebhookEventResponse {
	private String eventId;
    private String type;
    private String source;
    private LocalDateTime createdAt;
    private OrdersResponse orders;
}
