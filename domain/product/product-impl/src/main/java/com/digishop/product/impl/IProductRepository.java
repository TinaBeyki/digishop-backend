package com.digishop.product.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * JPARepository and MongoRepository are technology-specific abstraction of the Spring Data Repositories.
 *
 * If you are using RDBMS such as MySQL/PostgreSQL, you may use Spring Data Repositories such as JpaRepository.
 * If using a NoSQL such as Mongo, you will need the MongoReposiroty
 */

public interface IProductRepository extends MongoRepository<ProductEntity, ObjectId> {

    List<ProductEntity> findAllByCategory(String category);

    List<ProductEntity> findAllByBrand(String brand);

    List<ProductEntity> findAllByPriceBetween(Double minimumPrice, Double maximumPrice);
}
