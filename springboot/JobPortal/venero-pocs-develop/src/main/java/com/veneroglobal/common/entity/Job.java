package com.veneroglobal.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_title")
    private String jobTitle;
    private Integer vacanacy;
    private String location;
    private String status;
    private String industry;
    @Column(name = "job_created_dt")
    private Date jobCreatedDate;
    @Column(name = "expiry_dt")
    private Date jobExpiryDate;
    @Column(name = "apply_count")
    private Integer applyCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}
