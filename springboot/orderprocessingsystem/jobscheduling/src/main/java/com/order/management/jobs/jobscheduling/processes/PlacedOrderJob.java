package com.order.management.jobs.jobscheduling.processes;

import com.order.management.jobs.jobscheduling.dto.OrderRequest;
import com.order.management.jobs.jobscheduling.dto.OrderResponse;
import com.order.management.jobs.jobscheduling.entity.Order;
import com.order.management.jobs.jobscheduling.entity.Resturant;
import com.order.management.jobs.jobscheduling.repository.ResturantRepository;
import com.order.management.jobs.jobscheduling.utils.OrderProcessorCache;
import com.order.management.jobs.jobscheduling.utils.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlacedOrderJob {


    @Autowired
    private RestClient restClient;

    @Autowired
    private ResturantRepository resturantRepository;


    @Autowired
    private OrderProcessorCache orderProcessorCache;

    private final String ORDER_STATUS = "ORDER_PLACED";


    @Scheduled(fixedDelay = 50000)
    void fetchPlacedOrder()throws Exception{
        System.out.println("PlacedOrder :: job :: started");
        OrderResponse  orderResponse = this.restClient.fetchOrder(this.ORDER_STATUS);
        List<Order> orders = orderResponse.getOrderList();
        List<OrderRequest> readyToProcess = new ArrayList<>();

        if(orders.isEmpty()){
            throw new Exception("No New Order Has Been Placed..");
        }

        for(Order order: orders){
            OrderRequest request = new OrderRequest();
            request.setId(order.getId());
            request.setQuantity(order.getQuantity());
            request.setItem(order.getItem());
            request.setStatus("ORDER_PROCESSING");
            request.setRestaurantId(fetchRestaurantInformation());
            request.setLocation(order.getLocation());
            request.setEmailId(order.getEmailId());
            readyToProcess.add(request);
        }
        OrderResponse response = this.restClient.updateOrder(readyToProcess);
        response.getOrderList().forEach(order -> {
            System.out.println("Order with Id ::"+ order.getEmailId() + "  status :: "+ order.getStatus());

        });

        System.out.println("PlacedOrder :: job :: stopped");
    }

    private Integer fetchRestaurantInformation(){
        Resturant resturant = this.orderProcessorCache.fetchAllRestaurant().get(0);
        resturant.setOrdercount(resturant.getOrdercount() + 1);
        this.resturantRepository.save(resturant);
        return resturant.getId();
    }


}




















