package com.order.management.jobs.jobscheduling.dto;


import com.order.management.jobs.jobscheduling.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private List<Order> orderList;
    private Integer status;
    private Integer count;
}
