package com.order.management.jobs.jobscheduling.utils;


import com.order.management.jobs.jobscheduling.dto.OrderRequest;
import com.order.management.jobs.jobscheduling.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestClient {


    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:9000/api/v1/order";

    public OrderResponse fetchOrder(String status){
        String url = this.BASE_URL + "?status="+status;
        return this.restTemplate.getForObject(url, OrderResponse.class);
    }

    public OrderResponse updateOrder(List<OrderRequest> requests){
        String url = this.BASE_URL + "/update";
        return this.restTemplate.postForEntity(url, requests, OrderResponse.class).getBody();
    }

}
