package com.cerner.hexagonal.architecture.demo.customer.adapters;

import com.cerner.hexagonal.architecture.demo.customer.service.CustomerService;
import com.cerner.hexagonal.architecture.demo.customer.channels.InboundChannels;
import com.cerner.hexagonal.architecture.demo.customer.marker.adapter.InboundAdapter;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.OrderChargedEvent;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.OrderCreatedEvent;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.OrderNotChargedEvent;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.OrderShippedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(InboundChannels.class)
public class MessageConsumer implements InboundAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    private final CustomerService customerService;

    @Autowired
    public MessageConsumer(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @StreamListener(InboundChannels.ORDER_CREATED)
    public void orderCreated(final OrderCreatedEvent orderCreatedEvent) {
        LOGGER.debug("Received a '{}' event, the orderId is {}, the customer ID is {}",
                orderCreatedEvent.getName(), orderCreatedEvent.getOrderId(), orderCreatedEvent.getCustomerId());

        customerService.handleOrderCreated(orderCreatedEvent);
    }

    @StreamListener(InboundChannels.ORDER_CHARGED)
    public void orderCharged(final OrderChargedEvent orderChargedEvent) {
        LOGGER.debug("Received a '{}' event, the ID of the customer is {}",
                orderChargedEvent.getName(), orderChargedEvent.getCustomerId());

        customerService.handleOrderCharged(orderChargedEvent);
    }

    @StreamListener(InboundChannels.ORDER_NOT_CHARGED)
    public void orderNotCharged(final OrderNotChargedEvent orderNotChargedEvent) {
        LOGGER.warn("Received a '{}' event for the order {} of the customer {}",
                orderNotChargedEvent.getName(), orderNotChargedEvent.getOrderId(), orderNotChargedEvent.getCustomerId());

        customerService.handleOrderNotCharged(orderNotChargedEvent);
    }

    @StreamListener(InboundChannels.ORDER_SHIPPED)
    public void orderShipped(final OrderShippedEvent orderShippedEvent) {
        LOGGER.warn("Received a '{}' event for the order {} of the customer {}",
                orderShippedEvent.getName(), orderShippedEvent.getOrderId(), orderShippedEvent.getCustomerId());

        customerService.handleOrderShipped(orderShippedEvent);
    }
}
