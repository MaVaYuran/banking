package by.mariayun.data.dao;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;
import by.mariayun.data.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    private final SessionFactory sessionFactory;

    public CustomerDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> list = session.createQuery("FROM Customer", Customer.class).getResultList();

        return convertToDtoList(list);
    }

    private ArrayList<CustomerDto> convertToDtoList(List<Customer> list) {
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : list) {
            customerDtos.add(convertToDto(customer));
        }
        return customerDtos;
    }

    private CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customer.getLastname());
        customerDto.setEmail(customer.getEmail());
        customerDto.setRoleId(customer.getRole().getId());

        return customerDto;
    }


    @Override
    public CustomerDto getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer != null ? convertToDto(customer) : null;

    }

    @Override
    public int addCustomer(CustomerDto customerDto) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = mapToEntity(customerDto);
        return (int) session.save(customer);
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setEmail(customerDto.getEmail());
        Session session = this.sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, customerDto.getRoleId());
        if (role != null) {
            customer.setRole(role);
        }
        return customer;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerDto.getId());
        if (customer != null) {
            customer.setUsername(customerDto.getUsername());
            customer.setPassword(customerDto.getPassword());
            customer.setFirstname(customerDto.getFirstname());
            customer.setLastname(customerDto.getLastname());
            customer.setEmail(customerDto.getEmail());
            session = this.sessionFactory.getCurrentSession();
            Role role = session.get(Role.class, customerDto.getRoleId());
            if (role != null) {
                customer.setRole(role);
            }
            session.update(customer);
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            session.delete(customer);
            return true;
        } else
            return false;
    }

    @Override
    public Customer getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Сustomer WHERE username = :username", Customer.class);
        query.setParameter("username", username);
        return query.uniqueResult();

    }

    @Override
    public List<AccountDto> getAllAccounts(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        if (customer != null) {
            AccountDaoImpl accountDao = new AccountDaoImpl(sessionFactory);
            return customer.getAccounts().stream()
                    .map(accountDao::convertToDto)
                    .toList();
        }
        return new ArrayList<>();
    }

}
