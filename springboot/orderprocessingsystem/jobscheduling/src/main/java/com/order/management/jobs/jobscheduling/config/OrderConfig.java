package com.order.management.jobs.jobscheduling.config;


import com.order.management.jobs.jobscheduling.dto.OrderRequest;
import com.order.management.jobs.jobscheduling.dto.OrderResponse;
import com.order.management.jobs.jobscheduling.entity.Order;
import com.order.management.jobs.jobscheduling.repository.ResturantRepository;
import com.order.management.jobs.jobscheduling.utils.OrderProcessorCache;
import com.order.management.jobs.jobscheduling.utils.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableScheduling
public class OrderConfig {

    @Autowired
    private ResturantRepository resturantRepository;


    @Autowired
    private OrderProcessorCache orderProcessorCache;

    private final String ORDER_STATUS = "ORDER_PICKEDUP";

    @Autowired
    private RestClient restClient;



}
