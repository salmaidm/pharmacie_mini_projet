package com.salma.mini_projet_pharmacie.mapper;

import com.salma.mini_projet_pharmacie.dto.UserResponseDTO;
import com.salma.mini_projet_pharmacie.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toDto(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());           // ✅ toujours getId()
        dto.setNom(user.getNom());         // ✅ toujours getNom()
        dto.setEmail(user.getEmail());     // ✅ toujours getEmail()
        dto.setRole(user.getRole().name());// ✅ toujours getRole()
        return dto;
    }
}
