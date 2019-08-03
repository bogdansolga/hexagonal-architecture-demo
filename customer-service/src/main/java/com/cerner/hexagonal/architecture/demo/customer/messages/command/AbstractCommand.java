package com.cerner.hexagonal.architecture.demo.customer.messages.command;

import com.cerner.hexagonal.architecture.demo.customer.messages.AbstractMessage;

abstract class AbstractCommand extends AbstractMessage {

    AbstractCommand(long messageId) {
        super(messageId);
    }
}
