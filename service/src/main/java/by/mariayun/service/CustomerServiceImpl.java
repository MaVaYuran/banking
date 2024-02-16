package by.mariayun.service.service;

import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
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
    public CustomerDto getCustomerByUsername(String username) {
        return customerDAO.getCustomerByUsername(username);
    }

    @Override
    public String addCustomer(CustomerDto customerDto) {
        return customerDAO.addCustomer(customerDto);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
customerDAO.updateCustomer(customerDto);
    }

    @Override
    public boolean deleteCustomer(String username) {
        return customerDAO.deleteCustomer(username);
    }

    @Override
    public List<AccountDto> getAllAccounts(String customerId) {
        return customerDAO.getAllAccounts(customerId);
    }
}
