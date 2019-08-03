package com.cerner.hexagonal.architecture.demo.order.marker.message;

public @interface Subscriber {

    Service[] value();
}
