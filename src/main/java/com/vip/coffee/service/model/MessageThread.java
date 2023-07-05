package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "message_threads")
public class MessageThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coffee_machine_id")
    private CoffeeMachine machine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_status_id")
    private MessageThreadStatus status;
}
