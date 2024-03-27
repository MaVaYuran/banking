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
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    CustomerDao customerDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Customer customer = customerDAO.getUserByUsername(username);
            if (customer == null) {
                throw new UsernameNotFoundException(String.format("User '%s' not found", username));
            }
            return new User(
                    customer.getUsername(),
                    customer.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(customer.getRole().getRole()))
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException(String.format("User '%s' not found " , username));
        }
    }

    public CustomerDto register(CustomerDto customerDto, String username) {
        customerDto.setUsername(username);
        customerDto.setRoleId(2);

        int customerId = customerDAO.addCustomer(customerDto);
        return customerDAO.getById(customerId);

    }

    public CustomerDto getCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            Customer customer = customerDAO.getUserByUsername(username);
            if (customer != null) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(customer.getId());
                customerDto.setUsername(customer.getUsername());
                customerDto.setPassword(customer.getPassword());
                customerDto.setFirstname(customer.getFirstname());
                customerDto.setLastname(customer.getLastname());
                customerDto.setEmail(customer.getEmail());
                customerDto.setRoleId(customer.getRole().getId());
                return customerDto;
            }
        }
        return null;
    }
}
