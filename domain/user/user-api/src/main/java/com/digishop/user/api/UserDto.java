package com.digishop.user.api;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserDto {

    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean emailVerified;
    private String phone;
    private String password;
    private Map<String, Object> address = new HashMap<>();
    private Map<String, Object> shippingAddress = new HashMap<>();
}
