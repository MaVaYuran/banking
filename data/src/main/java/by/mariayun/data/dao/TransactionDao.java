package by.mariayun.data.dao;

import by.mariayun.data.dto.TransactionDto;
import by.mariayun.data.entity.Transaction;

import java.util.List;

public interface TransactionDao {
    List<TransactionDto> getTransactions();
    TransactionDto getTransactionById(int id);
    int addTransaction(TransactionDto transactionDto);
    void updateTransaction(TransactionDto transactionDto);
    boolean deleteTransaction(int id);

}
