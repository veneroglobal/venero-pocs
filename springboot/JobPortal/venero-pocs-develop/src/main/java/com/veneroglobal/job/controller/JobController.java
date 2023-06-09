package com.veneroglobal.job.controller;


import com.veneroglobal.common.dto.JobRequest;
import com.veneroglobal.common.entity.Job;
import com.veneroglobal.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/job")
    public ResponseEntity<?> saveJob(@RequestBody JobRequest jobRequest) {
        this.jobService.saveJob(jobRequest);
        return ResponseEntity.ok(jobRequest);
    }

    @GetMapping("/job")
    public ResponseEntity<?> fetchAllJob() {
        List<Job> allJobList = this.jobService.fetchAllJob();
        return ResponseEntity.ok(allJobList);

    }




    @GetMapping("/job/{id}")
    public ResponseEntity<?> fetchJobById(@PathVariable Integer id) throws Exception {
        Job jobById = this.jobService.fetchJobById(id);
        return ResponseEntity.ok(jobById);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) throws Exception {
        String message = this.jobService.deleteJobById(id);
        return ResponseEntity.ok(message);
    }
}
