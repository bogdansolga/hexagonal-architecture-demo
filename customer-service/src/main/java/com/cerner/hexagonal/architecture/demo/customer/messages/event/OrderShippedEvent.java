package com.cerner.hexagonal.architecture.demo.customer.messages.event;

import com.cerner.hexagonal.architecture.demo.customer.marker.message.Publisher;
import com.cerner.hexagonal.architecture.demo.customer.marker.message.Service;
import com.cerner.hexagonal.architecture.demo.customer.marker.message.Subscriber;

import java.time.LocalDateTime;

@Publisher(Service.ORDER_SERVICE)
@Subscriber({
        Service.BILLING_SERVICE,
        Service.CUSTOMER_SERVICE,
        Service.ORDER_SERVICE
})
public class OrderShippedEvent extends AbstractDomainEvent {

    private static final String NAME = "OrderShipped";

    private final long customerId;
    private final long orderId;
    private final LocalDateTime localDateTime;

    public OrderShippedEvent(final long messageId, final long eventId, final long customerId, long orderId) {
        super(messageId, eventId);
        this.customerId = customerId;
        this.orderId = orderId;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public String getName() {
        return NAME;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}