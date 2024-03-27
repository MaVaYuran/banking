package by.mariayun.data.dao;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<CustomerDto> getAllCustomers();
    CustomerDto getById(int id);
    int addCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);
    boolean deleteCustomer(int id);
    Customer getUserByUsername(String username);
    List<AccountDto> getAllAccounts(int customerId);

}
