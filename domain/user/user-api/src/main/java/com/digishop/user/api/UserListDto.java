package com.digishop.user.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListDto {

    private List<UserDto> userDtos = new ArrayList<>();
}
