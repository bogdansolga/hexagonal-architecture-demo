package com.cerner.hexagonal.architecture.demo.order.ports;

import com.cerner.hexagonal.architecture.demo.order.marker.port.OutboundPort;
import com.cerner.hexagonal.architecture.demo.order.message.event.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public interface MessagingOutboundPort extends OutboundPort {
    void publishOrderCreatedEvent(final OrderCreatedEvent orderCreatedEvent);
}
