package com.example.sweater.service;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public List<Message> findByTag(String tag) {
        return messageRepo.findByTag(tag);
    }

    public Iterable<Message> findAll() {
        return messageRepo.findAll();
    }

    @Transactional
    public void save(Message message) {
        messageRepo.save(message);
    }

    @Transactional
    public void deleteMessage(Message message) {
        messageRepo.delete(message);
    }
}