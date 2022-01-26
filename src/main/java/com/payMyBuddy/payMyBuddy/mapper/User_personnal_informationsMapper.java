package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;

@Service 
@Mapper(uses = {User_personnal_informationsMapper.class}, componentModel = "spring")
public interface User_personnal_informationsMapper {
User_personnal_informations_DTO toUserPersonnalInformationDTO(User_personnal_informations userPersonnalInformations);
User_personnal_informations  UserPersonnalnformations(User_personnal_informations_DTO userPersonnalInformationsDTO);
}
