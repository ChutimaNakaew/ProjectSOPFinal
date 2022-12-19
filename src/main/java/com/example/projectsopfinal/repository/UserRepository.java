package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query(value = "{name: '?0'}")
    public User findByName(String name);
    
}
