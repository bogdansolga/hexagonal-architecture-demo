package com.cerner.hexagonal.architecture.demo.customer.messages.event;

import com.cerner.hexagonal.architecture.demo.customer.marker.message.Publisher;
import com.cerner.hexagonal.architecture.demo.customer.marker.message.Service;
import com.cerner.hexagonal.architecture.demo.customer.marker.message.Subscriber;

import java.time.LocalDateTime;

@Publisher(Service.CUSTOMER_SERVICE)
@Subscriber(Service.BILLING_SERVICE)
public class CustomerCreatedEvent extends AbstractDomainEvent {

    private static final String NAME = "CustomerCreated";

    private final long customerId;
    private final String customerEmail;
    private final LocalDateTime creationTimeDate;

    public CustomerCreatedEvent(final long messageId, final long eventId, final long customerId, final String customerEmail) {
        super(messageId, eventId);
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.creationTimeDate = LocalDateTime.now();
    }

    @Override
    public String getName() {
        return NAME;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public LocalDateTime getCreationTimeDate() {
        return creationTimeDate;
    }
}
