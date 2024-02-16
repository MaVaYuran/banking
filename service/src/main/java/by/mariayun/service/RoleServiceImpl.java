package by.mariayun.service;

import by.mariayun.data.dao.RoleDao;
import by.mariayun.data.dto.RoleDto;
import by.mariayun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public RoleDto getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public int addRole(RoleDto roleDto) {
        return roleDao.addRole(roleDto);
    }

    @Override
    public boolean deleteRole(int id) {
        return roleDao.deleteRole(id);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
