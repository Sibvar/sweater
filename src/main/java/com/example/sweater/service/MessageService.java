package com.example.sweater.service;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

@Service
@Transactional(readOnly = true)
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Page<MessageDto> messageList (Pageable pageable, String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter, pageable, user);
        } else {
            return messageRepo.findAll(pageable, user);
        }
    }

    public Page<MessageDto> findByTag(String tag, Pageable pageable, User user) {
        return messageRepo.findByTag(tag, pageable, user);
    }

    public Page<MessageDto> findAll(Pageable pageable, User user) {
        return messageRepo.findAll(pageable, user);
    }

    @Transactional
    public void save(Message message) {
        messageRepo.save(message);
    }

    @Transactional
    public void deleteMessage(Message message) {
        messageRepo.delete(message);
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepo.findByUser(pageable, author, currentUser);
    }
}