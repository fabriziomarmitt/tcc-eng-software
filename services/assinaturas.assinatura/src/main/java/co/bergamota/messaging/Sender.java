package co.bergamota.messaging;

import co.bergamota.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger log = LoggerFactory.getLogger(Sender.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Sender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Event event) {
        log.info("Sending event...");
        rabbitTemplate.convertAndSend(Application.EXCHANGE_NAME, Application.ROUTING_KEY, event);
    }
}