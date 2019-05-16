package com.timproject.travelapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDTO {


    private long id;
    private String name;
    private String address;
    private String info;
    private double latitude;
    private double longitude;
    private boolean accepted;
    private boolean active;
    private long userId;
//    private String username;

}
