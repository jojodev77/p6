package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_account_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_account_informations;

@Service
@Mapper(uses = { User_account_informationsMapper.class }, componentModel = "spring")
public interface User_account_informationsMapper {
	User_account_informationsMapper INSTANCE = Mappers.getMapper(User_account_informationsMapper.class);

	User_account_informations_DTO toUser_account_informations_DTO(User_account_informations user_account_informations);

	User_account_informations toUser_account_informationsEntity(
			User_account_informations_DTO user_account_informations_DTO);

}
