package co.bergamota.services.messaging;

public class Event {
    private String event;
    private Object payload;

    public String getEvent() {
        return event;
    }

    public Event setEvent(String event) {
        this.event = event;
        return this;
    }

    public Object getPayload() {
        return payload;
    }

    public Event setPayload(Object payload) {
        this.payload = payload;
        return this;
    }
}
