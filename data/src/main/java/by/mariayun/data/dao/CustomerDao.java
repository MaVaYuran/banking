package by.mariayun.data.dao;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerByUsername(String username);
    String addCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);
    boolean deleteCustomer(String username);
    Customer getUserByUsername(String username);
    List<AccountDto> getAllAccounts(String customerId);
}
