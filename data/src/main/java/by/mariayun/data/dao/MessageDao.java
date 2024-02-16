package by.mariayun.data.dao;

import by.mariayun.data.entity.Message;

import java.util.List;

public interface MessageDao {
    int saveNewMessage(Message message);

    Message readMessageById(int id);

    boolean deleteMessageById(int id);

    List<Message> readAll();
}
