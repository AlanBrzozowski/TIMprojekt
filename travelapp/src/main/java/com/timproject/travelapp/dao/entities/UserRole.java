package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @OneToMany(mappedBy = "userRoleByUserRoleId")
    private Collection<User> usersById;

    public UserRole(){

    }
    public UserRole(String label, Collection<User> usersById){
        this.label=label;
        this.usersById = usersById;
    }

    public Collection<User> getUsersById() {
        return usersById;
    }
    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
