package by.mariayun.rest;


import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerDao customerDao;


    @GetMapping("/api/users/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") String id) {
        CustomerDto customer = customerDao.getCustomerByUsername(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/users/{id}")
    public CustomerDto crateCustomer(
            @PathVariable("id") String id,
            @RequestBody CustomerDto customerDto) {

        customerDto.setUsername(id);
        String customerId = customerDao.addCustomer(customerDto);
        return customerDao.getCustomerByUsername(customerId);
    }

    @PutMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public CustomerDto updateCustomer(
            @PathVariable("id") String id,
            @RequestBody CustomerDto customerDto) {
        customerDao.updateCustomer(customerDto);
        return customerDao.getCustomerByUsername(id);

    }

    @DeleteMapping("/api/useers/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(
            @PathVariable("id") String id) {
        customerDao.deleteCustomer(id);
    }

    @GetMapping("/api/users/{userId}/accounts")
    public List<AccountDto> getCustomerAccounts(
            @PathVariable String userId
    ) {
        return customerDao.getAllAccounts(userId);
    }
}



