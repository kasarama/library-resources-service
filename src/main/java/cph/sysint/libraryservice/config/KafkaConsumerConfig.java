package cph.sysint.libraryservice.config;

import cph.sysint.libraryservice.control.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
/*
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaUtil kafkaUtil;

    @Bean
    public ConsumerFactory<String, BookDto> messageConsumerFactory() {
        return this.kafkaUtil.createClassConsumerFactory(BookDto.class);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, BookDto>> messageFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BookDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.messageConsumerFactory());
        return factory;
    }
}
*/