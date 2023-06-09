package com.veneroglobal.common.dto;


import com.veneroglobal.common.entity.Address;
import com.veneroglobal.common.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyRequest {
    private Integer id;
    private String companyName;
    private Date foundedIn;
    private String typeOfMembership;
    private String email;
    private String status;
    private String areaOfOperation;
    private Address address;
    private Region region;
}

