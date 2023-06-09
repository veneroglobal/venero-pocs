package com.order.management.jobs.jobscheduling.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ResturantRequest {

    private String name;
    @Column(name = "order_count")
    private int orderCount;

}
