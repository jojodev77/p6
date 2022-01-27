package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;

@Component
@Mapper(uses = {User_personnal_informationsMapper.class,UserPersonnalConnexionMapper.class, User_addressMapper.class} , componentModel = "spring" )
public interface User_personnal_informationsMapper {
	
	User_personnal_informationsMapper INSTANCE = Mappers.getMapper( User_personnal_informationsMapper.class );
User_personnal_informations_DTO toUserPersonnalInformationDTO(User_personnal_informations userPersonnalInformations);
User_personnal_informations  toUserPersonnalInformations(User_personnal_informations_DTO userPersonnalInformationsDTO);
}
