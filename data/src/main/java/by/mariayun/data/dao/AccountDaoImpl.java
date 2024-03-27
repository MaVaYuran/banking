package by.mariayun.data.dao;

import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.entity.Account;
import by.mariayun.data.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    private final SessionFactory sessionFactory;

    public AccountDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> userAccountList = session.createQuery("FROM Account", Account.class).getResultList();
        return convertToDtoList(userAccountList);
    }

    private ArrayList<AccountDto> convertToDtoList(List<Account> accountList) {
        ArrayList<AccountDto> userAccountDtoList = new ArrayList<>();
        for (Account account : accountList) {
            userAccountDtoList.add(convertToDto(account));
        }
        return userAccountDtoList;

    }

    public AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCustomerId(account.getCustomer().getId());
        return accountDto;
    }

    @Override
    public AccountDto getAccountById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Account userAccount = session.get(Account.class, id);
        return userAccount != null ? convertToDto(userAccount) : null;
    }


    @Override
    public int addAccount(AccountDto accountDto) {
        Session session = this.sessionFactory.getCurrentSession();
        Account userAccount = convertToEntity(accountDto);
        return (int) session.save(userAccount);
    }

    private Account convertToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setBalance(accountDto.getBalance());
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, accountDto.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("Customer with id " + accountDto.getCustomerId() + " not found");
        }
        account.setCustomer(customer);
        return account;
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, accountDto.getId());
        if (account != null) {
            account.setBalance(accountDto.getBalance());
            session = this.sessionFactory.getCurrentSession();
            Customer customer = session.get(Customer.class, accountDto.getCustomerId());
            if (customer != null) {
                account.setCustomer(customer);
            }
            session.update(account);
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, id);
        if (account != null) {
            session.delete(account);
            return true;
        } else return false;

    }
}
