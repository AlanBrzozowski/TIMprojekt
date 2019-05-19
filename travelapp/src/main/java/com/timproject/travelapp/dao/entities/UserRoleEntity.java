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


    public UserRoleEntity(){

    }
    public UserRoleEntity(String label

    )
    {
        this.label=label;

    }


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
