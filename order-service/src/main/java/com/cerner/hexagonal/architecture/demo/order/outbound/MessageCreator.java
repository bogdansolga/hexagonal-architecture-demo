package com.cerner.hexagonal.architecture.demo.order.outbound;

import com.cerner.hexagonal.architecture.demo.order.message.AbstractMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

public final class MessageCreator {

    public static  <T extends AbstractMessage> Message<?> create(final T t) {
        return MessageBuilder.withPayload(t)
                             .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                             .build();
    }
}
