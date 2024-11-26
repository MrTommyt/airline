package com.example.airline.dto;

import com.example.airline.models.RoleType;

public class RoleDTO {
    private final Long id;
    private final RoleType role;

    public RoleDTO(Long id, RoleType role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public RoleType getRole() {
        return role;
    }
}
