package org.glenchiridza.amqp.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info(" PUBLISHING TO :: {} USING ROUTING KEY :: {} PAYLOAD :: {}", exchange, routingKey,payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info(" PUBLISHED TO :: {} USING ROUTING KEY :: {} PAYLOAD :: {}", exchange, routingKey,payload);
    }

}

// ended at 57_7
