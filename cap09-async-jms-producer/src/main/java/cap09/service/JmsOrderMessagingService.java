package cap09.service;

import org.examples.sia6.domain.order.TacoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    private final Logger LOG = LoggerFactory.getLogger(JmsOrderMessagingService.class);
    private JmsTemplate jms;

    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public TacoOrder sendOrder(TacoOrder order) {
        TacoOrder orderWithTimestamp =  TacoOrder.Builder.builder()
                .from(order).date(LocalDateTime.now())
                .build();
        LOG.info("SEND_ORDER_TO_JMS_QUEUE: {}", orderWithTimestamp);
        jms.convertAndSend("sia6.jms.queue", orderWithTimestamp);
        return orderWithTimestamp;
    }

}
