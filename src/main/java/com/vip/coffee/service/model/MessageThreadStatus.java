package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "message_thread_statuses")
public class MessageThreadStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
}
