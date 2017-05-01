package co.bergamota.messaging;

import co.bergamota.Application;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;


@Service
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    @Autowired
    ApplicationContext applicationContext;

    @RabbitListener(queues = Application.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = Application.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final Event event) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Reflections reflections = new Reflections("co.bergamota", new MethodAnnotationsScanner());
        Set<Method> methodSet = reflections.getMethodsAnnotatedWith(EventHandler.class);
        Optional<Method> eventHandler = methodSet.stream().filter(method -> method.getAnnotation(EventHandler.class).value().equals(event.getEvent())).findFirst();
        if(!eventHandler.isPresent()){
            log.info("Error handling not found for event:{}", event.getEvent());
            return;
        }
        Class<?> clazz = eventHandler.get().getDeclaringClass();
        Object eventHandlerInstance = applicationContext.getBean(clazz);
        eventHandler.get().invoke(eventHandlerInstance, event);
    }
}