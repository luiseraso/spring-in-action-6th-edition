package com.example.cap09asyncjmsconsumer.web;

import com.example.cap09asyncjmsconsumer.consumer.OrderReceiver;
import org.examples.sia6.domain.order.TacoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cap09/jms")
public class ReceiverController {

    private final Logger LOG = LoggerFactory.getLogger(ReceiverController.class);
    private OrderReceiver orderReceiver;

    public ReceiverController(OrderReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        return "{\"status\" : \"OK\"}";
    }

    @GetMapping(value = "/get-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder getOrder() {
        LOG.info("GET_ORDER");
        return orderReceiver.receiverOrder();
    }
}
