package com.order.management.system.ordermanagementsystem.dto;


import com.order.management.system.ordermanagementsystem.entity.Order;
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
