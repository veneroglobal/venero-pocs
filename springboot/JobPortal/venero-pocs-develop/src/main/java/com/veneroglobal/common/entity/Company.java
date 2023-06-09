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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "founded_in")
    private Date foundedIn;
    @Column(name = "type_of_membership")
    private String typeOfMembership;
    private String email;
    private String status;
    @Column(name = "area_of_operation")
    private String areaOfOperation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "job_id", referencedColumnName = "id")
//    private Job job;

}




