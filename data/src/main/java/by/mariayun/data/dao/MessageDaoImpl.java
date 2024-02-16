package by.mariayun.data.dao;

import by.mariayun.data.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MessageDaoImpl implements MessageDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int saveNewMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(message);//Some work
        return message.getId();

    }

    @Override
    @Transactional(readOnly = true)
    public Message readMessageById(int id) {
        Session session;
        Message message;
        session = sessionFactory.getCurrentSession();
        message = session.get(Message.class, id); //Some work
        return message;

    }

    @Override
    public boolean deleteMessageById(int id) {
        Session session;
        Message message;
        session = sessionFactory.getCurrentSession();
        message = session.get(Message.class, id); //Some work
        if (message == null) {
            return false;
        }
        session.remove(message);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> readAll() {
        Session session;
        session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message order by id", Message.class)
                .list();
    }

}
