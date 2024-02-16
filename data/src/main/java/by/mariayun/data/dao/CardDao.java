package by.mariayun.data.dao;

import by.mariayun.data.entity.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardDao {
    List<Card> getAllCards();
    Card getCard(int id);
    int addCard(Card card);
    void updateCard(Card card);
    boolean deleteCard(Card card);

    void updateCardBalance(int cardId, Integer balance) throws SQLException, ClassNotFoundException;
}
