package by.mariayun.service;

import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;
import by.mariayun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDAO ;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDAO) {
        this.customerDAO = customerDAO;
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        return customerDAO.getById(id);
    }

    @Override
    public int addCustomer(CustomerDto customerDto) {
        return customerDAO.addCustomer(customerDto);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
customerDAO.updateCustomer(customerDto);
    }

    @Override
    public boolean deleteCustomer(int username) {
        return customerDAO.deleteCustomer(username);
    }

    @Override
    public Customer getUserByUsername(String username) {
        return customerDAO.getUserByUsername(username);
    }

    @Override
    public List<AccountDto> getAllAccounts(int customerId) {
        return customerDAO.getAllAccounts(customerId);
    }
}
