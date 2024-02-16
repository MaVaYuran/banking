package by.mariayun.service;

import by.mariayun.data.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(int id);

    int addAccount(AccountDto accountDto);

    void updateAccount(AccountDto accountDto);

    boolean deleteAccount(int id);
}
