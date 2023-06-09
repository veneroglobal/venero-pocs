package com.order.management.jobs.jobscheduling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ordertable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private String location;
    @Column (name = "email_id")
    private String emailId;
    @Column (name = "item")
    private String item;
    private String status;
    @Column(name = "resturant_id")
    private Integer restaurantId;
    @Column(name = "agent_id")
    private Integer agentId;
}
