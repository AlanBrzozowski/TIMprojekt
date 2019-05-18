package com.timproject.travelapp.dao.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.timproject.travelapp.dao.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndActive(String username, boolean active);

    UserEntity findById(long id);
}
