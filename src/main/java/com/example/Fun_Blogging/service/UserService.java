package com.example.Fun_Blogging.service;

import com.example.Fun_Blogging.entityDTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO  userDTO);
    UserDTO updateUser(UserDTO userDTO,Integer userDTOId);
    UserDTO getUserByID(Integer userId);
    List<UserDTO> getAllUser();
    void deleteUser(Integer userId);
}
