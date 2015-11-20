package pi.lab3.chat.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public class Message implements Comparable<Message> {

    private User sender;
    private String message;
    private Date date;

    public Message() {

    }

    @JsonCreator
    public Message(@JsonProperty("sender") User sender, @JsonProperty("message") String message, @JsonProperty("date") Date date) {
        this.sender = sender;
        this.message = message;
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @NotBlank(message = "Message is required!")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message1 = (Message) o;

        return new EqualsBuilder()
                .append(sender, message1.sender)
                .append(message, message1.message)
                .append(date, message1.date)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sender)
                .append(message)
                .append(date)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sender", sender)
                .append("message", message)
                .append("date", date)
                .toString();
    }

    @Override
    public int compareTo(Message m1) {
        if (getDate().after(m1.getDate())) {
            return 1;
        } else if (getDate().before(m1.getDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}
