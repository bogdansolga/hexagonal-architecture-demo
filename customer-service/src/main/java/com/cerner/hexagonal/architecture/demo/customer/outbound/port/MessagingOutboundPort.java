package com.cerner.hexagonal.architecture.demo.customer.outbound.port;

import com.cerner.hexagonal.architecture.demo.customer.marker.port.OutboundPort;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.CustomerCreatedEvent;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.CustomerUpdatedEvent;
import org.springframework.stereotype.Component;

@Component
public interface MessagingOutboundPort extends OutboundPort {
    void publishCustomerCreatedEvent(final CustomerCreatedEvent customerCreatedEvent);

    void publishCustomerUpdatedEvent(final CustomerUpdatedEvent customerUpdatedEvent);
}
