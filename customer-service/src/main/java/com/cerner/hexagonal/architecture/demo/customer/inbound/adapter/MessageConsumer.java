package com.cerner.hexagonal.architecture.demo.customer.inbound.adapter;

import com.cerner.hexagonal.architecture.demo.customer.inbound.port.CustomerService;
import com.cerner.hexagonal.architecture.demo.customer.channels.InboundChannels;
import com.cerner.hexagonal.architecture.demo.customer.marker.adapter.InboundAdapter;
import com.cerner.hexagonal.architecture.demo.customer.messages.event.OrderCreatedEvent;
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
}
