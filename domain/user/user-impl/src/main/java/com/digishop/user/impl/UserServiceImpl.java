package com.digishop.user.impl;

import com.digishop.common.DateUtil;
import com.digishop.encryption.BCryptPasswordEncoderFactory;
import com.digishop.product.api.IProductService;
import com.digishop.product.api.ProductDto;
import com.digishop.user.api.IUserService;
import com.digishop.user.api.UserDto;
import com.digishop.user.api.UserListDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    private final IProductService iProductService;
    private final BCryptPasswordEncoderFactory bCryptPasswordEncoderFactory;

    public UserServiceImpl(IUserRepository iUserRepository, IProductService iProductService,
                           BCryptPasswordEncoderFactory bCryptPasswordEncoderFactory) {
        this.iUserRepository = iUserRepository;
        this.iProductService = iProductService;
        this.bCryptPasswordEncoderFactory = bCryptPasswordEncoderFactory;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public UserDto srvcSignUp(UserDto userDto) {
        UserDto dto = null;
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setPassword(bCryptPasswordEncoderFactory.encoder().encode(userDto.getPassword()));
        userEntity.setCreatedDateAndTime(DateUtil.getLocalDateAndTime());
        UserEntity savedUser = iUserRepository.save(userEntity);

        if (savedUser != null) {
            dto = new UserDto();
            BeanUtils.copyProperties(savedUser, dto);
        }
        return dto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public UserDto srvcSignIn(UserDto userDto) {
        UserEntity userFoundByEmailOrPhone = iUserRepository.findByEmail(userDto.getEmail());
        UserDto dto = null;

        if (userFoundByEmailOrPhone != null) {

            //comparison of users pass and hashed password in database
            boolean matches =
                    bCryptPasswordEncoderFactory.encoder().matches(userDto.getPassword(), userFoundByEmailOrPhone.getPassword());

            if(matches) {
                dto = new UserDto();
                BeanUtils.copyProperties(userFoundByEmailOrPhone, dto);
            }
        }
        return dto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public UserDto srvcUpdateUserProfile(UserDto userDto) {
        UserDto updatedUserDto = null;
        UserEntity userFoundById = iUserRepository.findById(userDto.getId()).orElse(null);

        if(userFoundById != null) {
            BeanUtils.copyProperties(userDto, userFoundById);
            UserEntity updatedUser = iUserRepository.save(userFoundById);
            if(updatedUser != null) {
                updatedUserDto = new UserDto();
                BeanUtils.copyProperties(updatedUser, updatedUserDto);
            }
        }
        return updatedUserDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public UserListDto srvcFindAllUsers() {
        UserListDto userListDto = new UserListDto();
        List<UserDto> userDtos = new ArrayList<>();

        List<UserEntity> allUsers = iUserRepository.findAll();
        if(allUsers != null && !allUsers.isEmpty()) {
            allUsers.forEach(userEntity -> {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(userEntity, userDto);
                userDtos.add(userDto);
            });
        }
        userListDto.setUserDtos(userDtos);
        return userListDto;
    }
    //------------------------------------------------------------------------------------------------------------------

   /* @Override
    public ProductDto addProductToCart(ProductDto productDto) {
        iProductService.
    }*/

}
