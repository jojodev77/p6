package com.payMyBuddy.payMyBuddy.dto;

import com.payMyBuddy.payMyBuddy.entity.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDto {

	private ERole name;
}
