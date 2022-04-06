package com.example.cap09asyncjmsconsumer.consumer;

import org.examples.sia6.domain.order.TacoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiver implements OrderReceiver {

    private final Logger LOG = LoggerFactory.getLogger(JmsOrderReceiver.class);
    private JmsTemplate jms;

    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public TacoOrder receiverOrder() {
        LOG.info("RECEIVE_ORDER_INIT");
        TacoOrder order = (TacoOrder) jms.receiveAndConvert("sia6.jms.queue");
        LOG.info("RECEIVE_ORDER_END. Order: {}", order);
        return order;
    }

}
