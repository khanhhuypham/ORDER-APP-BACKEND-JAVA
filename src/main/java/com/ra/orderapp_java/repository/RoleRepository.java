package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
