package com.myproject.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myproject.myproject.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
