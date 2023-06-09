package com.order.management.system.ordermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private Integer id;
    private String item;
    private String location;
    private String emailId;
    private int quantity;
    private Integer restaurantId;
    private Integer agentId;
    private String status;
}
