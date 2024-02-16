package by.mariayun.data.dao;

import by.mariayun.data.dto.TransactionDto;
import by.mariayun.data.entity.Card;
import by.mariayun.data.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    private final SessionFactory sessionFactory;

    public TransactionDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TransactionDto> getTransactions() {
        Session session = sessionFactory.getCurrentSession();
        List<Transaction> transactions = session.createQuery("FROM transaction").getResultList();

        return convertToDtoList(transactions);
    }

    private List<TransactionDto> convertToDtoList(List<Transaction> transactions) {
        Session session = sessionFactory.getCurrentSession();
        List<TransactionDto> dtoList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            dtoList.add(mapToDto(transaction));
        }
        return dtoList;
    }

    private TransactionDto mapToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setValue(transaction.getValue());
        transactionDto.setPaydate(transaction.getPaydate());
        return transactionDto;
    }

    @Override
    public TransactionDto getTransactionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.get(Transaction.class, id);
        return transaction != null ? mapToDto(transaction) : null;
    }

    @Override
    public int addTransaction(TransactionDto transactionDto) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = mapToEntity(transactionDto);
        return (int) session.save(transaction);
    }

    private Transaction mapToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setValue(transactionDto.getValue());
        transaction.setPaydate(transactionDto.getPaydate());
        Session session = this.sessionFactory.getCurrentSession();
        Card card = session.get(Card.class, transactionDto.getCardId());
        if (card != null) {
            transaction.setCard(card);
        }
        return transaction;
    }

    @Override
    public void updateTransaction(TransactionDto transactionDto) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.get(Transaction.class, transactionDto.getId());
        if (transaction != null) {
            transaction.setValue(transactionDto.getValue());
            transaction.setPaydate(transactionDto.getPaydate());
            session = this.sessionFactory.getCurrentSession();
            Card card = session.get(Card.class, transactionDto.getId());
            if (card != null) {
                transaction.setCard(card);
            }
            session.update(transaction);
        }

    }

    @Override
    public boolean deleteTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.get(Transaction.class, id);
        if (transaction != null) {
            session.delete(transaction);
            return true;
        } else {
            return false;
        }
    }
}
