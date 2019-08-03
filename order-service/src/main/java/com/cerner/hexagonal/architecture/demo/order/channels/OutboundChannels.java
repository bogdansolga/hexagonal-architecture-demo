package com.cerner.hexagonal.architecture.demo.order.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutboundChannels {
    // the channel on which 'OrderCreated' events are sent
    String ORDER_CREATED = "order_created";

    @Output(ORDER_CREATED)
    MessageChannel orderCreated();
}