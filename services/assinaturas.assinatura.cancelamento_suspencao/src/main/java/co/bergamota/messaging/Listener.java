package co.bergamota.messaging;

import co.bergamota.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    @RabbitListener(queues = Application.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = Application.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final Event event) {
        log.info("Received message as specific class: {}", event.toString());
    }
}