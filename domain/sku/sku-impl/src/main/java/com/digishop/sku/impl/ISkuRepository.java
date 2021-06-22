package com.digishop.sku.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISkuRepository extends MongoRepository<SkuEntity, ObjectId> {
}
