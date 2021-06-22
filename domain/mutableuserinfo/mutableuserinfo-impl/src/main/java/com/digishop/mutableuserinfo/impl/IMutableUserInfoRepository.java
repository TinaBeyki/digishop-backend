package com.digishop.mutableuserinfo.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMutableUserInfoRepository extends MongoRepository<MutableUserInfoEntity, ObjectId> {
}
