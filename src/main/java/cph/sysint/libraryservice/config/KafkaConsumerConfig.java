package cph.sysint.libraryservice.config;

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