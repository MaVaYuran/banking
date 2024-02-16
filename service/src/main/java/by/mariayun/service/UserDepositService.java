package by.mariayun.service;

import by.mariayun.data.dto.UserDepositsDto;

import java.util.*;

public interface UserDepositService {
    List<UserDepositsDto> getAllUserDeposits();
    UserDepositsDto getUserDeposit(int id);
    int addUserDeposit(UserDepositsDto userDepositsDto);
    void updateUserDeposit(UserDepositsDto userDepositsDto);
    boolean deleteUserDeposit(UserDepositsDto userDepositsDto);
}