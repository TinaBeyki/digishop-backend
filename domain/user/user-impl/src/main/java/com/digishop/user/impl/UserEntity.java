package com.digishop.user.impl;

import com.digishop.user.api.embedded_document.Address;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "users")
public class UserEntity {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean emailVerified;
    private String password; //password must be hashed
    private LocalDateTime birthDate;
    private String nationalCode;
    private Address addresse; //embedded address
    private Map<String, Object> shippingAddress = new HashMap<>(); // receiver name and receiver phone
    private Boolean isActive; // confirm email , ta ghablesh nemituni kharid koni
    private String createdDateAndTime;

    //activation code field
    /*
    address and shippingAddress fields -> country, street 1, street 2 , city, province, zip
    address is where you get your bills and shipping address is where you want to receive your order
     */
}
