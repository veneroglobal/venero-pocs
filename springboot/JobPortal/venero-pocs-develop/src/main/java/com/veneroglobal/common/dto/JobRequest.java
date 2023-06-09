package com.veneroglobal.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
        private Integer id;
        private String jobDescription;
        private String jobTitle;
        private Integer vacanacy;
        private String location;
        private String status;
        private String industry;
        private Date jobCreatedDate;
        private Date jobExpiryDate;
        private Integer applyCount;
}

