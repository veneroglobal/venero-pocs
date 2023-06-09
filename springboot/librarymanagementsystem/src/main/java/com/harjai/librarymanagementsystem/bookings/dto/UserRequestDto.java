package com.harjai.librarymanagementsystem.bookings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto{


    private long id ;
    private Date IuuseingDate;
}
