package com.veneroglobal.jobscheduling;


import com.veneroglobal.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;


public class JobApplyingScheduling {
    @Autowired
    private JobRepository jobRepository;

    @Scheduled(fixedDelay = 5000)
    void createJob() {


    }
}
