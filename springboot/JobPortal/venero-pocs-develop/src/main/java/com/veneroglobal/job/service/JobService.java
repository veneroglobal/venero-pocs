package com.veneroglobal.job.service;


import com.veneroglobal.common.dto.JobRequest;
import com.veneroglobal.common.entity.Job;
import com.veneroglobal.job.controller.JobController;
import com.veneroglobal.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public Job saveJob(JobRequest jobRequest) {
        Job job = new Job();

        job.setJobTitle(jobRequest.getJobTitle());
        job.setJobDescription(jobRequest.getJobDescription());
        job.setVacanacy(jobRequest.getVacanacy());
        job.setLocation(jobRequest.getLocation());
        job.setJobCreatedDate(jobRequest.getJobCreatedDate());
        job.setJobExpiryDate(jobRequest.getJobExpiryDate());
        job.setStatus(jobRequest.getStatus());


        Job savedJob = this.jobRepository.save(job);
        return job;
    }


    public List<Job> fetchAllJob() {
        return (List<Job>) this.jobRepository.findAll();
    }

    public Job fetchJobById(Integer id) throws Exception {
        Optional<Job> job = this.jobRepository.findById(id);
        if (job.isPresent()) {
            return job.get();
        }
        throw new Exception("Job not found");
    }

    public String deleteJobById(Integer id) throws Exception {
        try {
            this.jobRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Job not found in the system..");
        }
        return "Job successfully Removed";

    }
}

