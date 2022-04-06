package cap09.web;

import cap09.service.JmsOrderMessagingService;
import cap09.service.OrderMessagingService;
import org.examples.sia6.domain.order.TacoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/cap09/jms")
public class JmsController {

    private final Logger LOG = LoggerFactory.getLogger(JmsController.class);
    OrderMessagingService orderMessagingService;

    public JmsController(OrderMessagingService orderMessagingService) {
        this.orderMessagingService = orderMessagingService;
    }

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        System.out.println("health()...");
        return "{\"status\" : \"OK\"}";
    }

    @PostMapping(value = "/send-order",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder sendOrder(@RequestBody TacoOrder order) {
        LOG.info("NEW_ORDER: {}", order);
        return orderMessagingService.sendOrder(order);

    }
}
