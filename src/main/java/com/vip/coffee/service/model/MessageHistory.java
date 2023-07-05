package com.vip.coffee.service.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message_history")
public class MessageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_thread_id")
    private MessageThread thread;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private User sender;

    private String message;

    private LocalDateTime time;
}
