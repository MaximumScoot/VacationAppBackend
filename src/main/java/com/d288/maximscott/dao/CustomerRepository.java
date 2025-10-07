package com.d288.maximscott.dao;

import com.d288.maximscott.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//granting permission for requests from front end
@CrossOrigin("http://localhost:4200")
//declaring interfaces that extends JpaRepository to manage objects through Spring Boot
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
