package com.cerner.hexagonal.architecture.demo.order;

import com.cerner.hexagonal.architecture.demo.order.adapters.MessageCreator;
import com.cerner.hexagonal.architecture.demo.order.channels.InboundChannels;
import com.cerner.hexagonal.architecture.demo.order.message.command.CreateOrderCommand;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner publishTestCreateOrderMessage(final InboundChannels inboundChannels) {
		return args -> inboundChannels.createOrder()
									  .send(MessageCreator.create(
			  new CreateOrderCommand(547L,  324L, "An useful tablet",200L)));
	}
}
