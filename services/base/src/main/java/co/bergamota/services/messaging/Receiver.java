package co.bergamota.services.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver implements MessageListener    {

    private CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}