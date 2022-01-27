package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.UserDTO;
import com.payMyBuddy.payMyBuddy.entity.User;

@Service 
@Mapper(uses = {UserMapper.class}, componentModel = "spring")
public interface UserMapper {
UserDTO toUserDTO(User user);
User toUser(UserDTO userDTO);
}
