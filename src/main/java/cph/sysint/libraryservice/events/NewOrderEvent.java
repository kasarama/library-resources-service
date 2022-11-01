package cph.sysint.libraryservice.events;

import cph.sysint.libraryservice.dto.BookDto;
import cph.sysint.libraryservice.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

public class NewOrderEvent {

    @Autowired
    TitleService titleService;

    private static final Logger logger = LoggerFactory.getLogger(NewOrderEvent.class);

    @KafkaListener(topics = "bookBought", groupId = "order-group")
    public void consume(BookDto bookDto) throws IOException {
        System.out.println("Consumed event with id:" + bookDto.getId());
        logger.info("&&& Event [{}] consumed", bookDto.getId());
        titleService.decreaseQuantity(bookDto.getId());
    }

}
