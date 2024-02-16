package by.mariayun.data.dao;

import by.mariayun.data.dto.RoleDto;

import java.util.List;

public interface RoleDao {
    RoleDto getRoleById(int id);
    int addRole(RoleDto roleDto);
    boolean deleteRole(int id);
    List<RoleDto> getAllRoles();
}
