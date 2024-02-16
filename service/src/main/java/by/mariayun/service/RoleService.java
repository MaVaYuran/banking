package by.mariayun.service;

import by.mariayun.data.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getRoleById(int id);
    int addRole(RoleDto roleDto);
    boolean deleteRole(int id);
    List<RoleDto> getAllRoles();
}
