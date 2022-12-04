package hu.webuni.cloud.api.controller;

import hu.webuni.cloud.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping(value = "/recent", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getRecentMessages() {
        return service.getRecentMessages();
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Object> newMessageArrived(@RequestBody String message) {
        service.createNewMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
