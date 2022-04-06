package cap09.service;

import org.examples.sia6.domain.order.TacoOrder;

public interface OrderMessagingService {
    TacoOrder sendOrder(TacoOrder order);
}
