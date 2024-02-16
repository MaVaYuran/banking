package by.mariayun.web.controller;

import by.mariayun.data.dao.MessageDao;
import by.mariayun.data.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private MessageDao messageDao;

    @GetMapping("/feedback")
    public String feedback(Model model) {
        List<Message> messages=messageDao.readAll();
        model.addAttribute("messages", messages);
        return "/feedback";
    }

    @GetMapping("/feedback/add")
    public String feedbackAdd(Model model) {

        return "/feedback-add";
    }
}
