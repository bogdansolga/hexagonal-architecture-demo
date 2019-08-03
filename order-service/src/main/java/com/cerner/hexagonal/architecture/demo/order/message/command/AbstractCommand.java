package com.cerner.hexagonal.architecture.demo.order.message.command;

import com.cerner.hexagonal.architecture.demo.order.message.AbstractMessage;

abstract class AbstractCommand extends AbstractMessage {

    AbstractCommand(long messageId) {
        super(messageId);
    }
}
