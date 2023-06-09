package com.order.management.jobs.jobscheduling.processes;

import com.order.management.jobs.jobscheduling.dto.OrderRequest;
import com.order.management.jobs.jobscheduling.dto.OrderResponse;
import com.order.management.jobs.jobscheduling.entity.Agent;
import com.order.management.jobs.jobscheduling.entity.Order;
import com.order.management.jobs.jobscheduling.repository.AgentRepository;
import com.order.management.jobs.jobscheduling.repository.ResturantRepository;
import com.order.management.jobs.jobscheduling.utils.OrderProcessorCache;
import com.order.management.jobs.jobscheduling.utils.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProcessingOrder {
    @Autowired
    private RestClient restClient;



    @Autowired
    private ResturantRepository resturantRepository;
        @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private OrderProcessorCache orderProcessorCache;

    private final String ORDER_STATUS = "ORDER_PROCESSING";

    @Scheduled(fixedDelay = 50000)
    void fetchPlacedOrder() {
        System.out.println("ORDER_PROCESSING :: job :: started");
        OrderResponse orderResponse = this.restClient.fetchOrder(this.ORDER_STATUS);
        List<Order> orders = orderResponse.getOrderList();
        List<OrderRequest> readyToProcess = new ArrayList<>();

        for (Order order : orders) {
            OrderRequest request = new OrderRequest();
            request.setId(order.getId());
            request.setQuantity(order.getQuantity());
            request.setItem(order.getItem());
            request.setStatus("ORDER_PICKED_UP");
            request.setRestaurantId(order.getRestaurantId());
            request.setAgentId(fetchAgentInformation());
            request.setEmailId(order.getEmailId());
            request.setLocation(order.getLocation());
            readyToProcess.add(request);
        }

        OrderResponse response = this.restClient.updateOrder(readyToProcess);
        response.getOrderList().forEach(order -> {
            System.out.println("Order with Id ::" + order.getEmailId() + "  status :: " + order.getStatus());

        });
        System.out.println("PROCESSING_ORDER :: job :: stopped");

    }

    private Integer fetchAgentInformation() {
        Agent agent = this.orderProcessorCache.fetchAllAgent().get(0);
        agent.setOrdercount(agent.getOrdercount() + 1);
        this.agentRepository.save(agent);
        return agent.getId();
    }

}
