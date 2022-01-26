package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_address_DT0;
import com.payMyBuddy.payMyBuddy.entity.User_address;



@Service 
@Mapper(uses = {User_addressMapper.class}, componentModel = "spring")
public interface User_addressMapper {
User_address_DT0 toUser_addressDTO(User_address user_address);
User_address toUser_addressEntity(User_address_DT0 user_address);
}
