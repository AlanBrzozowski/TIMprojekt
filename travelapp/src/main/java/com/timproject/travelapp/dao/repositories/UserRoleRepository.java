package com.timproject.travelapp.dao.repositories;

import com.timproject.travelapp.dao.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findAll();

    UserRoleEntity findById(long id);
}
