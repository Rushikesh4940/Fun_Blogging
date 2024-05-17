package com.example.Fun_Blogging.service;

import com.example.Fun_Blogging.entity.User;
import com.example.Fun_Blogging.entityDTO.UserDTO;
import com.example.Fun_Blogging.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Fun_Blogging.repository.UserRepo;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user= UserDTOtouser(userDTO);
        User savedUser=this.userRepo.save(user);
        UserDTO userDTO1=usertoUserDTO(savedUser);
        return userDTO1;
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO,Integer userDTOId) {
        User user=this.userRepo.findById(userDTOId).orElseThrow(()-> new ResourceNotFoundException("User","userID",userDTOId));
        user.setName(userDTO.getName());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        this.userRepo.save(user);
        UserDTO updateduserDTO= usertoUserDTO(user);
        return  updateduserDTO;

    }

    @Override
    public UserDTO getUserByID(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userID",userId));
        UserDTO gotuserDTO=usertoUserDTO(user);
        return  gotuserDTO;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList=this.userRepo.findAll();
        List<UserDTO> userDTOList=userList.stream().map(user -> this.usertoUserDTO(user)).collect(Collectors.toList());
        return userDTOList ;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userID",userId));
        this.userRepo.delete(user);
    }
    private User UserDTOtouser(UserDTO userDTO){
//        User user= new User();
//        user.setId(userDTO.getId());
//        user.setAbout(userDTO.getAbout());
//        user.setEmail(userDTO.getEmail());
//        user.setName(userDTO.getName());
//        user.setPassword(userDTO.getPassword());
        User user =this.modelMapper.map(userDTO,User.class);
        return user;
    }
    private UserDTO usertoUserDTO(User user){
        UserDTO userDTO =this.modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
}
