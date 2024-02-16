package by.mariayun.data.dao;

import by.mariayun.data.entity.Message;

import java.util.List;

public interface MessageDao {
    Long saveNewMessage(Message message);

    Message readMessageById(Long id);

    boolean deleteMessageById(Long id);

    List<Message> readAll();
}
