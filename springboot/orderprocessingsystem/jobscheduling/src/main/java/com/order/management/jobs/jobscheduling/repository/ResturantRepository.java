package com.order.management.jobs.jobscheduling.repository;

import com.order.management.jobs.jobscheduling.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepository extends JpaRepository<Resturant, Integer> {


}
