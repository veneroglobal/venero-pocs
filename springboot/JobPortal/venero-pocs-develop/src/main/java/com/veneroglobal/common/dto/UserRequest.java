package com.veneroglobal.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    private Integer id;
    private String name;
    private String emailId;
    private Integer phoneNumber;
    private Integer age;
    private String qualification;
    private String location;
    private Integer numberOfJobsApplied;
    private String membershipType;
}
