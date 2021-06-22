package com.digishop.mutableuserinfo.impl;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@Document(collection = "mutableUserInfoََ")
public class MutableUserInfoEntity {

    private ObjectId id;
    private ObjectId userId;
    private String token;
    private String status;
    private Date expirationDate;
    private Date requestTime;

}
