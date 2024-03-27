package by.maria.data.dao;

import by.maria.data.EBankingTestDataSource;
import by.maria.data.TestDataConfiguration;
import by.mariayun.data.EBankingDataSource;
import by.mariayun.data.dao.AccountDao;
import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dao.RoleDao;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.data.dto.RoleDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.Statement;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class CustomerDaoImplTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AccountDao accountDao;

    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = EBankingTestDataSource.getConnection();
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM account;");
            statement.executeUpdate("DELETE FROM customer;");
            statement.executeUpdate("DELETE FROM t_role;");

        }
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        customerDao = null;
        roleDao = null;
        accountDao = null;
    }

    @Test
    public void getAllCustomers() {
    }

    @Test
    public void getCustomerById() {
        // Given
        CustomerDto expectedUser = new CustomerDto();
        expectedUser.setUsername("XXX");
        expectedUser.setPassword("111");
        expectedUser.setFirstname("John");
        expectedUser.setLastname("Doe");
        expectedUser.setEmail("q@tut.by");
        RoleDto roleDto = new RoleDto();
        roleDto.setRole("Admin");
        int roleId = roleDao.addRole(roleDto);
        expectedUser.setRoleId(roleId);
        int id = customerDao.addCustomer(expectedUser);

        // When
        CustomerDto actualUser = customerDao.getById(id);

        // Then
        assertNotNull(actualUser);
        assertEquals(expectedUser.getFirstname(), actualUser.getFirstname());
        assertEquals(expectedUser.getLastname(), actualUser.getLastname());
        assertEquals(expectedUser.getRoleId(), actualUser.getRoleId());
        assertEquals(id, actualUser.getId());
    }



    @Test
    @Ignore
    public void addCustomer() {
        // Given
        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstname("John");
        customerDto.setLastname("Doe");
        RoleDto roleDto = new RoleDto();
        roleDto.setRole("Admin");
        int roleId = roleDao.addRole(roleDto);
        customerDto.setRoleId(roleId);

        // When
        int id = customerDao.addCustomer(customerDto);

        // Then
        CustomerDto addedUser = customerDao.getById(id);
        assertNotNull(addedUser);
        assertEquals(customerDto.getFirstname(), addedUser.getFirstname());
        assertEquals(customerDto.getLastname(), addedUser.getLastname());
        assertEquals(customerDto.getRoleId(), addedUser.getRoleId());
        assertEquals(id, addedUser.getId());
    }


    @Test
    public void updateCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void getUserByUsername() {
    }

    @Test
    public void getAllAccounts() {
    }
}