package com.digishop.inventory.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface IInventoryRepository extends MongoRepository<InventoryEntity, ObjectInput> {
}
