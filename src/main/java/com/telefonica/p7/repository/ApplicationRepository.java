package com.telefonica.p7.repository;

import com.telefonica.p7.model.Application;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository  extends CrudRepository<Application,String> {
    @Query("SELECT * FROM APPLICATIONS WHERE APPLICATIONS.ID= :id")
    public Iterable<Application> getApplicationByID(String id);
} 
