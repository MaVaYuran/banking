package by.mariayun.service;

import by.mariayun.data.dto.CardDto;
import by.mariayun.data.entity.Card;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    Card getCard(int id);
    int addCard(Card card);
    void updateCard(Card card);
    boolean deleteCard(Card card);
     void deposit(Integer amount, CardDto cardDto) throws SQLException, ClassNotFoundException;
    void withdrow(Integer amount, CardDto cardDto) throws SQLException, ClassNotFoundException;
    void transfer(Integer amount, CardDto cardDto);


}
