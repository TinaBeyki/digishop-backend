package com.digishop.cart.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ICartRepository extends MongoRepository<CartEntity, ObjectId> {

    Optional<CartEntity> findById(ObjectId cartId);

    CartEntity findByUserId(ObjectId userId);
}
