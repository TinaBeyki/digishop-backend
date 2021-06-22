package com.digishop.productsku.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductSkuRepository extends MongoRepository<ProductSkuEntity, ObjectId> {
}
