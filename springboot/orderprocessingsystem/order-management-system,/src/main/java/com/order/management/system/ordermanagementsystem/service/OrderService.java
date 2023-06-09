package com.order.management.system.ordermanagementsystem.service;

import com.order.management.system.ordermanagementsystem.dto.OrderRequest;
import com.order.management.system.ordermanagementsystem.dto.OrderResponse;
import com.order.management.system.ordermanagementsystem.entity.Order;
import com.order.management.system.ordermanagementsystem.repository.OrderRepository;
import com.order.management.system.ordermanagementsystem.util.OrderConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderResponse saveOder(@PathVariable OrderRequest orderRequest){
        Order order = new Order();

        order.setEmailId(orderRequest.getEmailId());
        order.setQuantity(orderRequest.getQuantity());
        order.setLocation(orderRequest.getLocation());
        order.setItem(orderRequest.getItem());
        order.setStatus(OrderConstants.ORDER_PLACED);
        Order savedorder = this.orderRepository.save(order);
        // have it another DTO with name OrderResponse
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderList(Arrays.asList(order));
        orderResponse.setCount(1);
        orderResponse.setStatus(HttpStatus.OK.value());
        return orderResponse;
    }


    public OrderResponse fetchPlacedOrder(String status)
    {
        OrderResponse order = new OrderResponse();
        List<Order> orderListByStatus = this.orderRepository.findByStatus(status);
        order.setOrderList(orderListByStatus);
        order.setCount(orderListByStatus.size());
        order.setStatus(HttpStatus.OK.value());
        return order;
    }

    public OrderResponse updateOrder(List<OrderRequest> orderRequests){

        List<Order> orderList = new ArrayList<>();

        for(OrderRequest orderRequest: orderRequests){
            Order order = new Order();
            order.setId(orderRequest.getId());
            order.setRestaurantId(orderRequest.getRestaurantId());
            order.setAgentId(orderRequest.getAgentId());
            order.setEmailId(orderRequest.getEmailId());
            order.setQuantity(orderRequest.getQuantity());
            order.setLocation(orderRequest.getLocation());
            order.setItem(orderRequest.getItem());
            order.setStatus(orderRequest.getStatus());
            orderList.add(order);
        }

        List<Order> orderList1 = this.orderRepository.saveAll(orderList);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderList(orderList1);
        orderResponse.setCount(orderList1.size());
        orderResponse.setStatus(HttpStatus.OK.value());
        return orderResponse;
    }

}
