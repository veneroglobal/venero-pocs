package com.order.management.jobs.jobscheduling.repository;

import com.order.management.jobs.jobscheduling.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {


}
