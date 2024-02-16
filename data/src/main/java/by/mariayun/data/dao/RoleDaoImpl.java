package by.mariayun.data.dao;

import by.mariayun.data.dto.RoleDto;
import by.mariayun.data.entity.Customer;
import by.mariayun.data.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoleDto getRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, id);
        if (role != null) {
            convertToDto(role);
        }
        return null;
    }
    private RoleDto convertToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        roleDto.setCustomerId(role.getCustomer().getUsername());
        return roleDto;
    }

    @Override
    public int addRole(RoleDto roleDto) {
        Session session = this.sessionFactory.getCurrentSession();//???
        Role role = new Role();
        role.setRole(roleDto.getRole());
        session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, roleDto.getCustomerId());
        if (customer != null) ;
        role.setCustomer(customer);
        return (int) session.save(role);
    }

    @Override
    public boolean deleteRole(int id) {

        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, id);
        if (role != null) {
            session.delete(role);
            return true;

        } else {
            throw new IllegalArgumentException("Role " + id + " not found");
        }

    }

    @Override
    public List<RoleDto> getAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roles = getRoleList();
        return convertToDtoList(roles);
    }

    private List<Role> getRoleList() {
        var session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("FROM t_role", Role.class);
        return query.list();
    }


    private ArrayList<RoleDto> convertToDtoList(List<Role> roles) {
        ArrayList<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            roleDtos.add(convertToDto(role));
        }
        return roleDtos;
    }
//   for addRole method
//    private Role convertToEntity(RoleDto roleDto) {
//        Role role = new Role();
//        role.setRole(roleDto.getRole());
//        var session = sessionFactory.getCurrentSession();
//        var customer = session.get(Customer.class, roleDto.getCustomerId());
//        if (customer != null) {
//            role.setCustomer(customer);
//        }
//        return role;
//    }

}
