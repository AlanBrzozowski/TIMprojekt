package com.timproject.travelapp.dao.entities;


import javax.persistence.*;


@Entity
public class PlaceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String info;
    private Double latitude;
    private Double longitude;
    private Boolean accepted;
    private Boolean active;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @ManyToOne
    @JoinColumn (name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private UserEntity userEntity;


    public PlaceEntity() {
    }

    public PlaceEntity(String name, String address, String info, Double latitude, Double longitude, Boolean accepted, Boolean active, long userId, UserEntity userEntity) {
        this.name = name;
        this.address = address;
        this.info = info;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accepted = accepted;
        this.active = active;
        this.userId = userId;
        this.userEntity = userEntity;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
