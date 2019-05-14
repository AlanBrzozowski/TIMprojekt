package com.timproject.travelapp.dao.entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String info;
    private Double latitude;
    private Double longitude;
    private Boolean accepted;
    private Boolean active;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private User userByUserId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<Visit> visitsById;

    public Place() {
    }

    public Place(String name, String address, String info, Double latitude, Double longitude, Boolean accepted, Boolean active, Long userId, User userByUserId, Collection<Visit> visitsById) {
        this.name = name;
        this.address = address;
        this.info = info;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accepted = accepted;
        this.active = active;
        this.userId = userId;
        this.userByUserId = userByUserId;
        this.visitsById = visitsById;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Collection<Visit> getVisitsById() {
        return visitsById;
    }

    public void setVisitsById(Collection<Visit> visitsById) {
        this.visitsById = visitsById;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
