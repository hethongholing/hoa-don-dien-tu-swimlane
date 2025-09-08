package com.Swimlane.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Swimlane.Service.WebhookService;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {

	@Autowired
	private WebhookService webhookService;
	
	@PostMapping("/merchant")
    public ResponseEntity<String> handleMerchantWebhook(
            @RequestHeader("X-Signature") String signature,
            @RequestHeader("X-Nonce") String nonce,
            @RequestBody String payload) {

        webhookService.processWebhook(signature, nonce, payload);
        return ResponseEntity.ok("Received");
    }
}
