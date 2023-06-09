package com.harjai.librarymanagementsystem.bookings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class User {

    @OneToOne()
    private long user_id ;
    @OneToOne()
    private  long book_id;
    private String issuedby;

    @Column(name = "issueing_dt")
     private Date IuuseingDate;

    @Column(name = "renewal_dt")
     private Date RenewalDate;


}
