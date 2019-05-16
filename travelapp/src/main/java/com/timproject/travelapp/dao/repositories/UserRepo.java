package com.timproject.travelapp.dao.repositories;


import com.timproject.travelapp.dao.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();

    User findById(long id);
}
