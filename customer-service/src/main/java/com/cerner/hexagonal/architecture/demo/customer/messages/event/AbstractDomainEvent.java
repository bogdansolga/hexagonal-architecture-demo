package com.cerner.hexagonal.architecture.demo.customer.messages.event;

import com.cerner.hexagonal.architecture.demo.customer.messages.AbstractMessage;

abstract class AbstractDomainEvent extends AbstractMessage {

    private final long eventId;

    AbstractDomainEvent(long messageId, long eventId) {
        super(messageId);
        this.eventId = eventId;
    }

    public long getEventId() {
        return eventId;
    }
}
