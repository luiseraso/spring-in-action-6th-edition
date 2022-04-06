package com.example.cap09asyncjmsconsumer.consumer;

import org.examples.sia6.domain.order.TacoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderListener {

    private final Logger LOG = LoggerFactory.getLogger(JmsOrderListener.class);

    @JmsListener(destination = "sia6.jms.queue")
    public void receiveOrder(TacoOrder order) {
        LOG.info("ORDER_RECEIVED: {}", order);
    }
}
