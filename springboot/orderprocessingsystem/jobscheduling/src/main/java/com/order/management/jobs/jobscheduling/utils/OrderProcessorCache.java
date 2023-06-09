package com.order.management.jobs.jobscheduling.utils;


import com.order.management.jobs.jobscheduling.entity.Agent;
import com.order.management.jobs.jobscheduling.entity.Resturant;
import com.order.management.jobs.jobscheduling.repository.AgentRepository;
import com.order.management.jobs.jobscheduling.repository.ResturantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderProcessorCache {


    private List<Resturant> resturants = new ArrayList<>();






    private List<Agent> agents = new ArrayList<>();


    @Autowired
    private ResturantRepository resturantRepository;

    @Autowired
    private AgentRepository agentReposiory;

    @PostConstruct
    public void injectStaticData(){
        List<Resturant> allRestros = this.resturantRepository.findAll();
        if(!allRestros.isEmpty())
            this.resturants.addAll(allRestros);
        List<Agent> allAgent = this.agentReposiory.findAll();
        if(!allAgent.isEmpty())
            this.agents.addAll(allAgent);
    }


    public List<Agent> fetchAllAgent(){
        return this.agents;
    }

    public List<Resturant> fetchAllRestaurant(){
        return this.resturants;
    }



}
