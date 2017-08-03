package com.example.demo.domain.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long>
{
    User findByUsername(String username);
}
