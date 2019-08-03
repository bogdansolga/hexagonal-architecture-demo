package com.cerner.hexagonal.architecture.demo.order.adapters;

import com.cerner.hexagonal.architecture.demo.order.channels.OutboundChannels;
import com.cerner.hexagonal.architecture.demo.order.ports.MessagingOutboundPort;
import com.cerner.hexagonal.architecture.demo.order.message.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OutboundChannels.class)
public class MessageProducer implements MessagingOutboundPort {

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
