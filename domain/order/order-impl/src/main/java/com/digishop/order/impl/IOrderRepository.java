package com.digishop.order.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<OrderEntity, ObjectId> {
}
