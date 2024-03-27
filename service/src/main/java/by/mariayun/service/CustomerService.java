package by.mariayun.service;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;

import java.util.List;


public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(int id);

    int addCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    boolean deleteCustomer(int username);

    Customer getUserByUsername(String username);
    List<AccountDto> getAllAccounts(int customerId);






    //    public Optional<CustomerDTO> getCustomer(Long id) {
//        return  customerDAO.findCustomerById(1l)
//                .map(it-> new CustomerDTO());
//
//    }
}
