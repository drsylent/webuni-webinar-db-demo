package hu.webuni.cloud.service;

import hu.webuni.cloud.db.entity.MessageEntity;
import hu.webuni.cloud.db.repository.MessageRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

class MessageServiceTest {

    private static final MessageRepository repository = Mockito.mock(MessageRepository.class);
    private static final MessageService service = new MessageService(repository);

    @Test
    void getRecentMessages() {
        String message = "test";
        Mockito.when(repository.findFirst5ByOrderByDateDesc()).thenReturn(List.of(new MessageEntity(message, LocalDate.now())));

        List<String> recentMessages = service.getRecentMessages();
        MatcherAssert.assertThat(recentMessages, Matchers.contains(message));
    }

    @Test
    void createNewMessage() {
        String message = "creation";

        service.createNewMessage(message);

        Mockito.verify(repository, Mockito.atLeastOnce()).save(Mockito.any());
    }

}