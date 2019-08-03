package com.cerner.hexagonal.architecture.demo.order.outbound.adapter;

import com.cerner.hexagonal.architecture.demo.order.outbound.MessageCreator;
import com.cerner.hexagonal.architecture.demo.order.channels.OutboundChannels;
import com.cerner.hexagonal.architecture.demo.order.message.event.OrderCreatedEvent;
import com.cerner.hexagonal.architecture.demo.order.outbound.port.MessagingOutboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OutboundChannels.class)
public class MessageProducer implements MessagingOutboundPort, OutboundAdapter {

    private final OutboundChannels outboundChannels;

    @Autowired
    public MessageProducer(final OutboundChannels outboundChannels) {
        this.outboundChannels = outboundChannels;
    }

    public void publishOrderCreatedEvent(final OrderCreatedEvent orderCreatedEvent) {
        outboundChannels.orderCreated()
                        .send(MessageCreator.create(orderCreatedEvent));
    }
}
