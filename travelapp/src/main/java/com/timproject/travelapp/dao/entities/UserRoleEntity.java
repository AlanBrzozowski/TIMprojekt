package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    @OneToMany(mappedBy = "userRoleEntity")
    private Collection<UserEntity> userEntities;
//    @OneToMany(mappedBy = "userRoleByUserRoleId")
//    private Collection<UserEntity> usersById;

    public UserRoleEntity(){

    }
    public UserRoleEntity(String label
//                    Collection<UserEntity> usersById
    )
    {
        this.label=label;
//        this.usersById = usersById;
    }
//
//    public Collection<UserEntity> getUsersById() {
//        return usersById;
//    }
//    public void setUsersById(Collection<UserEntity> usersById) {
//        this.usersById = usersById;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
