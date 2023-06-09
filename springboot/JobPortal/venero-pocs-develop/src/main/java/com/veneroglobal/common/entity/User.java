package com.veneroglobal.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    private Integer age;
    private String qualification;
    private String location;
    @Column(name = "number_of_jobs_applied")
    private Integer numberOfJobsApplied;
    @Column(name = "membership_type")
    private String membershipType;

//@OneToMany(cascade = CascadeType.ALL)
//@JoinColumn(name = "job_id", referencedColumnName = "id")
//private Job job;
}
