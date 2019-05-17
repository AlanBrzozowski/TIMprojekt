package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @OneToMany(mappedBy = "userRoleEntity")
    private Collection<UserEntity> userEntities;

    public UserRoleEntity(){

    }
    public UserRoleEntity(String label, Collection<UserEntity> userEntities)
    {
        this.label=label;
        this.userEntities = userEntities;
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
