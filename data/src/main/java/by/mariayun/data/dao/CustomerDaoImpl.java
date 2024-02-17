package by.mariayun.data.dao;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;
import by.mariayun.data.entity.Role;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        List<Customer> list = session.createQuery("FROM customer", Customer.class).getResultList();

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
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setRoleId(customer.getRole().getId());

        return customerDto;
    }


    @Override
    public CustomerDto getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, username);
        return customer != null ? convertToDto(customer) : null;

    }

    @Override
    public String addCustomer(CustomerDto customerDto) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = mapToEntity(customerDto);
        return (String) session.save(customer);
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
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
        Customer customer = session.get(Customer.class, customerDto.getUsername());
        if (customer != null) {
            customer.setPassword(customerDto.getPassword());
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customer.setEmail(customerDto.getEmail());
            session = this.sessionFactory.getCurrentSession();
            Role role = session.get(Role.class, customerDto.getRoleId());
            if(role != null) {
                customer.setRole(role);
            }
            session.update(customer);
        }
    }

    @Override
    public boolean deleteCustomer(String username) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, username);
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
    public List<AccountDto> getAllAccounts(String customerId) {
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
