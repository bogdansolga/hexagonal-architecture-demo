package com.cerner.hexagonal.architecture.demo.order.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface InboundChannels {
    // the channel on which 'CreateOrder' commands are received
    String CREATE_ORDER = "create_order";

    // the channel on which 'CustomerUpdated' events are received
    String CUSTOMER_UPDATED = "customer_updated";

    @Input(CREATE_ORDER)
    MessageChannel createOrder();

    @Input(CUSTOMER_UPDATED)
    MessageChannel customerUpdated();
}