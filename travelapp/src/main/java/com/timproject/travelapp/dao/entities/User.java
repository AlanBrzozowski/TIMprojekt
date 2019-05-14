package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean active;
    @Column(name = "user_role_id", nullable = false)
    private Long userRoleId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Place> placesById;
    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private UserRole userRoleByUserRoleId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Visit> visitsById;

    public User() {

    }

    public User(String username, String password, Boolean active, Long userRoleId, Collection<Place> placesById, UserRole userRoleByUserRoleId, Collection<Visit> visitsById){
        this.username = username;
        this.password = password;
        this.active = active;
        this.userRoleId = userRoleId;
        this.placesById = placesById;
        this.userRoleByUserRoleId = userRoleByUserRoleId;
        this.visitsById  = visitsById;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Collection<Place> getPlacesById() {
        return placesById;
    }

    public void setPlacesById(Collection<Place> placesById) {
        this.placesById = placesById;
    }

    public UserRole getUserRoleByUserRoleId() {
        return userRoleByUserRoleId;
    }

    public void setUserRoleByUserRoleId(UserRole userRoleByUserRoleId) {
        this.userRoleByUserRoleId = userRoleByUserRoleId;
    }

    public Collection<Visit> getVisitsById() {
        return visitsById;
    }

    public void setVisitsById(Collection<Visit> visitsById) {
        this.visitsById = visitsById;
    }
}
