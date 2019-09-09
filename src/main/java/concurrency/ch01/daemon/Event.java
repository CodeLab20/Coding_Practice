package concurrency.ch01.daemon;

import java.util.Date;

public class Event {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    private String description;
    private Date eventDate;
}
