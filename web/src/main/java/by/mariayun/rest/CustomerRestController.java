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


    @GetMapping("/api/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") int id) {
        CustomerDto customer = customerDao.getById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/customers/{id}")
    public CustomerDto crateCustomer(
            @PathVariable("id") int id,
            @RequestBody CustomerDto customerDto) {

        customerDto.setId(id);
        int customerId = customerDao.addCustomer(customerDto);
        return customerDao.getById(customerId);
    }

    @PutMapping("/api/customers/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public CustomerDto updateCustomer(
            @PathVariable("id") int id,
            @RequestBody CustomerDto customerDto) {
        customerDao.updateCustomer(customerDto);
        return customerDao.getById(id);

    }

    @DeleteMapping("/api/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(
            @PathVariable("id") int id) {
        customerDao.deleteCustomer(id);
    }

    @GetMapping("/api/customers/{customerId}/accounts")
    public List<AccountDto> getCustomerAccounts(
            @PathVariable int customerId
    ) {
        return customerDao.getAllAccounts(customerId);
    }
}



