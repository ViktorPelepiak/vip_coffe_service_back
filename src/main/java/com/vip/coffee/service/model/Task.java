package com.vip.coffee.service.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_type_id")
    private TaskType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_status_id")
    private TaskStatus status;

    private String estimation;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Column(name = "input_information")
    private String inputInformation;

    @Column(name = "output_information")
    private String outputInformation;
}
