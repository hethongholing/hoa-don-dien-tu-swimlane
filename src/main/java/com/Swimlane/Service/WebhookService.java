package com.Swimlane.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Swimlane.Entity.Events;
import com.Swimlane.Entity.Orders;
import com.Swimlane.Mapper.OrderMapper;
import com.Swimlane.Repository.EventsRepository;
import com.Swimlane.Repository.OrdersRepository;
import com.Swimlane.dto.response.OrdersResponse;

@Service
public class WebhookService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Value("${webhook.secret:defaultSecret}")
    private String secret; 
	

    public void processWebhook(String signature, String nonce, String payload) {
        // 1. Verify HMAC
        if (!verifySignature(signature, payload)) {
            throw new RuntimeException("Invalid signature");
        }

        // 2. Chống replay (check nonce + TTL trong Redis/DB)
        if (!isValidNonce(nonce)) {
            throw new RuntimeException("Replay detected");
        }

        // 3. Lưu raw_event vào bảng events
        Events event = new Events();
        event.setSource("merchant");
        event.setEventId(UUID.randomUUID().toString());
        event.setPayload(payload);
        event.setProcessed(false);
        event.setCreatedAt(LocalDateTime.now());
        eventsRepository.save(event);

        // 4. Parse JSON thành Order + OrderItems
        parseAndSaveOrder(payload);
    }

    private boolean verifySignature(String signature, String payload) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            String expected = Base64.getEncoder().encodeToString(mac.doFinal(payload.getBytes()));
            return expected.equals(signature);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidNonce(String nonce) {
        // TODO: check trong Redis hoặc DB với TTL
        return true;
    }

    private void parseAndSaveOrder(String payload) {
        // TODO: Dùng Jackson parse JSON thành Order + OrderItems
        // Example:
        // ObjectMapper mapper = new ObjectMapper();
        // OrderDto dto = mapper.readValue(payload, OrderDto.class);
        // Convert dto -> entity -> save
    }
    
    public void saveOrderFromDto(OrdersResponse orderDto, String rawPayload) {
        Orders orders = orderMapper.toOrders(orderDto);

        // set liên kết 2 chiều (order <-> items)
        orders.getItems().forEach(item -> item.setOrder(orders));

        // lưu raw_payload
        orders.setRawPayload(rawPayload);

        ordersRepository.save(orders);
    }
}
