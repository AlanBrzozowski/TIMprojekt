package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private Boolean active;
    @OneToMany(mappedBy = "userEntity")
    private Collection<PlaceEntity> placeEntities;
    @Column(name = "user_role_id", nullable = false)
    private long userRoleId;
    @ManyToOne
    @JoinColumn (name = "user_role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private UserRoleEntity userRoleEntity;

    public UserEntity() {

    }

    public UserEntity(String username, String password, Boolean active, Set<PlaceEntity> placeEntities) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.placeEntities = placeEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }
}
