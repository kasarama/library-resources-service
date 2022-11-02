package cph.sysint.libraryservice.events;

import cph.sysint.libraryservice.exeption.TitleOutOfStockException;
import cph.sysint.libraryservice.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NewOrderEvent {

    @Autowired
    TitleService titleService;

    private static final Logger logger = LoggerFactory.getLogger(NewOrderEvent.class);

    @KafkaListener(topics = "bookBought", groupId = "order-group")
    public void consume(String bookId) throws IOException, TitleOutOfStockException {
        // TODO(magdalena): WHAT THE FUCK
        bookId = bookId.replaceAll("\"", "");
        int id = Integer.parseInt(bookId);
        System.out.println("Consumed event with id:" + id);
        logger.info("&&& Event [{}] consumed", id);
        titleService.decreaseQuantity(id);
    }
}