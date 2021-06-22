package com.digishop.user.api;

public interface IUserService {

    UserDto srvcSignUp(UserDto userDto);

    // for input parameter we just need email or phone and password, if output is not null means signedIn successfully
    UserDto srvcSignIn(UserDto userDto);

    UserDto srvcUpdateUserProfile(UserDto userDto);

    UserListDto srvcFindAllUsers();
}
