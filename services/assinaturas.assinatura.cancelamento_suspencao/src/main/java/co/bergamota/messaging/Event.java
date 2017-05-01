package co.bergamota.messaging;

import java.io.Serializable;

public final class Event implements Serializable{

    private Object payload;
    private String event;

    public Event() {}

    public Event(Object payload, String event) {
        this.payload = payload;
        this.event = event;
    }

    public Object getPayload() {
        return payload;
    }

    public Event setPayload(Object payload) {
        this.payload = payload;
        return this;
    }

    public String getEvent() {
        return event;
    }

    public Event setEvent(String event) {
        this.event = event;
        return this;
    }
}