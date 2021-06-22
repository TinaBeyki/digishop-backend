package com.digishop.user.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPARepository and MongoRepository are technology-specific abstraction of the Spring Data Repositories.
 *
 * If you are using RDBMS such as MySQL/Postgre SQL, you may use Spring Data Repositories such as JpaRepository.
 * If using a NoSQL such as Mongo, you will need the MongoRepository
 */
@Repository
public interface IUserRepository extends MongoRepository<UserEntity, ObjectId> {

    UserEntity findByEmail(String email);

    UserEntity findByEmailOrPhone(String email, String phone);
}
