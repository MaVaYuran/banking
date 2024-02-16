package by.mariayun.data.dao;

import by.mariayun.data.EBankingDataSource;
import by.mariayun.data.entity.Card;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CardDaoImpl implements CardDao {
    private final SessionFactory sessionFactory;

    public CardDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Card> getAllCards() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Card> query = session.createQuery("FROM card", Card.class);
            return new ArrayList<>(query.list());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There are no cards");
            return null;
        }
    }

    @Override
    public Card getCard(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Card card = session.get(Card.class, id);
            return card;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Card not found");
            return null;
        }
    }

    @Override
    public int addCard(Card card) {
        try {
            Session session = sessionFactory.getCurrentSession();
            int cardId = (int) session.save(card);
            return cardId;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Card cannot be added");
            return -1;
        }
    }

    @Override
    public void updateCard(Card card) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(card);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Card cannot be updated");
        }
    }

    @Override
    public boolean deleteCard(Card card) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(card);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Card cannot be deleted");
            return false;
        }

    }

    @Override
    public void updateCardBalance(int id, Integer balance) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE card SET balance =? WHERE id=? ";
        PreparedStatement statement = EBankingDataSource.getConnection().prepareStatement(sql);
        statement.setInt(1, balance);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }
}
