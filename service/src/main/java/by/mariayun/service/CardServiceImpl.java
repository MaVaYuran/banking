package by.mariayun.service;

import by.mariayun.data.dao.CardDao;
import by.mariayun.data.dto.CardDto;
import by.mariayun.data.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;
@Autowired
    public CardServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public List<Card> getAllCards() {
        return null;
    }

    @Override
    public Card getCard(int id) {
        return null;
    }

    @Override
    public int addCard(Card card) {
        return 0;
    }

    @Override
    public void updateCard(Card card) {

    }

    @Override
    public boolean deleteCard(Card card) {
        return false;
    }

    @Override
    public void deposit(Integer amount, CardDto cardDto) throws SQLException, ClassNotFoundException {
        Integer balance = cardDto.getBalance();
        balance += amount;
        cardDao.updateCardBalance(cardDto.getId(),balance);
    }


    @Override
    public void withdrow(Integer amount, CardDto cardDto) throws SQLException, ClassNotFoundException {
        Integer balance = cardDto.getBalance();
        if (balance >= amount) {
            balance -= amount;
        }else{
            throw new IllegalArgumentException("Transaction withdrow impossible");
        }
        cardDao.updateCardBalance(cardDto.getId(), balance);
    }

    @Override
    public void transfer(Integer amount, CardDto cardDto) {
        try {
            deposit(amount,cardDto);
            withdrow(amount, cardDto);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
