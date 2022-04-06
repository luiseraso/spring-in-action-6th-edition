package com.example.cap09asyncjmsconsumer.consumer;

import org.examples.sia6.domain.order.TacoOrder;

public interface OrderReceiver {
    TacoOrder receiverOrder();
}
