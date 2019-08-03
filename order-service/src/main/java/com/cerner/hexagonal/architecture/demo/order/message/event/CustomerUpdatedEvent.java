package com.cerner.hexagonal.architecture.demo.order.message.event;

import com.cerner.hexagonal.architecture.demo.order.marker.message.Publisher;
import com.cerner.hexagonal.architecture.demo.order.marker.message.Service;
import com.cerner.hexagonal.architecture.demo.order.marker.message.Subscriber;

@Publisher(Service.CUSTOMER_SERVICE)
@Subscriber(Service.ORDER_SERVICE)
public class CustomerUpdatedEvent extends AbstractDomainEvent {

    private static final String NAME = "CustomerUpdated";

    private final long customerId;

    public CustomerUpdatedEvent(final long messageId, final long eventId, final long customerId) {
        super(messageId, eventId);
        this.customerId = customerId;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public long getCustomerId() {
        return customerId;
    }
}
