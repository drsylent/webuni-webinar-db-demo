package hu.webuni.cloud.db.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "message")
public class MessageEntity {

    public MessageEntity() {
    }

    public MessageEntity(String message, LocalDate date) {
        this.message = message;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }
}
