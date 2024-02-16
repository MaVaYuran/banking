package by.mariayun.service;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;

import java.util.List;


public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerByUsername(String username);

    String addCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    boolean deleteCustomer(String username);

    //Customer getUserByUsername(String username);
    List<AccountDto> getAllAccounts(String customerId);






    //    public Optional<CustomerDTO> getCustomer(Long id) {
//        return  customerDAO.findCustomerById(1l)
//                .map(it-> new CustomerDTO());
//
//    }
}
