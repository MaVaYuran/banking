package by.mariayun.service.service;

import by.mariayun.data.dao.AccountDao;
import by.mariayun.data.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    public AccountDto getAccountById(int id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public int addAccount(AccountDto accountDto) {
        return accountDao.addAccount(accountDto);
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
accountDao.updateAccount(accountDto);
    }

    @Override
    public boolean deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }
}
