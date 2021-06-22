package com.digishop.launcher.controller;

import com.digishop.common.MethodNames;
import com.digishop.common.ServiceNames;
import com.digishop.user.api.IUserService;
import com.digishop.user.api.UserDto;
import com.digishop.user.api.UserListDto;
import com.digishop.user.impl.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/" + ServiceNames.USERS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.SIGN_UP)
    //sign up with google acount
    public UserDto signUp(@RequestBody UserDto userDto) {
        return iUserService.srvcSignUp(userDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.SIGN_IN)
    public UserDto signIn(@RequestBody UserDto userDto) {
        return iUserService.srvcSignIn(userDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ALL_USERS)
    public UserListDto findAllUsers() {
        return iUserService.srvcFindAllUsers();
    }
    //------------------------------------------------------------------------------------------------------------------

    // check if user is activate or not
    @PostMapping(path = "/" + MethodNames.ADD_PRODUCT_TO_CART)
    public void addProductToCart() {
    }
    //------------------------------------------------------------------------------------------------------------------
    /*
    public void addPayment() {

    }*/


    // generate token  for authentication

/*@PostMapping("/")
    public List<UserEntity> findTablesName() {
        List<UserEntity> all = iUserService.findAll();
        System.out.println(all.get(0).getAddress().get("city"));
        return iUserService.findAll();
    }*/
}
