package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.model.admin;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;

@Repository
public interface adminRepository extends CrudRepository<admin, String> {

    @Query(value = "{username: '?0'}")
    public admin findByUsername(String username);

//    @Query(value = "{username: '?0'}")
//    public Iterable<admin> findByUsername(String username);
}
