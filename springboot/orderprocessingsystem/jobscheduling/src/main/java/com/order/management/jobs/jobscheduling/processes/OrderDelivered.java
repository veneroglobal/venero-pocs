package com.order.management.jobs.jobscheduling.processes;


import com.order.management.jobs.jobscheduling.dto.OrderRequest;
import com.order.management.jobs.jobscheduling.dto.OrderResponse;
import com.order.management.jobs.jobscheduling.entity.Agent;
import com.order.management.jobs.jobscheduling.entity.Order;
import com.order.management.jobs.jobscheduling.repository.AgentRepository;
import com.order.management.jobs.jobscheduling.utils.OrderProcessorCache;
import com.order.management.jobs.jobscheduling.utils.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDelivered {

    @Autowired
    private RestClient restClient;

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private OrderProcessorCache orderProcessorCache;

    private final String ORDER_STATUS = "ORDER_PICKED_UP";

    @Scheduled(fixedDelay = 50000)
    void fetchPlacedOrder() {
        System.out.println("ORDER_DELIVERED :: started");
        OrderResponse orderResponse = this.restClient.fetchOrder(this.ORDER_STATUS);
        List<Order> orders = orderResponse.getOrderList();
        List<OrderRequest> readyToProcess = new ArrayList<>();

        for (Order order : orders) {
            OrderRequest request = new OrderRequest();
            request.setId(order.getId());
            request.setQuantity(order.getQuantity());
            request.setItem(order.getItem());
            request.setRestaurantId(order.getRestaurantId());
            request.setAgentId(order.getAgentId());
            request.setStatus("ORDER_DELIVERED");
            request.setEmailId(order.getEmailId());
            request.setLocation(order.getLocation());
            readyToProcess.add(request);

        }

        OrderResponse response = this.restClient.updateOrder(readyToProcess);
        response.getOrderList().forEach(order -> {
            System.out.println("Order with Id ::" + order.getEmailId() + "  status :: " + order.getStatus());

        });
        System.out.println("DELIVERED_ORDER :: job :: stopped");


    }


}
