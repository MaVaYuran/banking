package by.mariayun.service.security;

import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class AuthenticationService implements UserDetailsService {

    @Autowired
    CustomerDao customerDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Customer customer = customerDAO.getUserByUsername(username);
            if (customer == null) {
                throw new UsernameNotFoundException("Username is incorrect");
            }
            return new User(
                    customer.getUsername(),
                    customer.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(customer.getRole().getRole()))
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException("Username not found", e);
        }
    }

    public CustomerDto register(CustomerDto customerDto, String username) {
        customerDto.setUsername(username);
        customerDto.setRoleId(2);

        String customerId = customerDAO.addCustomer(customerDto);
        return customerDAO.getCustomerByUsername(customerId);

    }

    public CustomerDto getCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            var customer = customerDAO.getUserByUsername(username);
            if (customer != null) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setUsername(customer.getUsername());
                customerDto.setPassword(customer.getPassword());
                customerDto.setFirstName(customer.getFirstName());
                customerDto.setLastName(customer.getLastName());
                customerDto.setEmail(customer.getEmail());
                return customerDto;
            }
        }
        return null;
    }
}
