package by.mariayun.service.service;

import by.mariayun.data.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    Card getCard(int id);
    int addCard(Card card);
    void updateCard(Card card);
    boolean deleteCard(Card card);

}
