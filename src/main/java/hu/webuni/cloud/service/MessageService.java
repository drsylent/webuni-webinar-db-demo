package hu.webuni.cloud.service;

import hu.webuni.cloud.db.entity.MessageEntity;
import hu.webuni.cloud.db.repository.MessageRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void createNewMessage(String message) {
        var newEntity = new MessageEntity(message, LocalDate.now());
        repository.save(newEntity);
    }

    public List<String> getRecentMessages() {
        return repository.findFirst5ByOrderByDateDesc().stream().map(MessageEntity::getMessage).toList();
    }
}
