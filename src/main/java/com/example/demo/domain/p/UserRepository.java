package com.example.demo.domain.p;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<com.example.demo.domain.p.User,Integer>
{

        com.example.demo.domain.p.User findByName(String name);

        @Query("from User u where u.name=:name")
        com.example.demo.domain.p.User findUser(@Param("name")String name);

        com.example.demo.domain.p.User findByNameAndAge(String name, Integer age);
}

