package com.payMyBuddy.payMyBuddy.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_personnal_connexion_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;

@Service 
@Mapper(uses = {User_addressMapper.class}, componentModel = "spring")
public interface UserPersonnalConnexionMapper {
User_personnal_connexion toUserPersonnalConnexion(User_personnal_connexion_DTO userPersonnalConnexionDTO);
User_personnal_connexion_DTO toUserPersonnalConnexionDTO(User_personnal_connexion userPersonnalConnexion);
}
