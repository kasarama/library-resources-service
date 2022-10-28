package cph.sysint.libraryservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TitleRepositoryTest {

    @Autowired
    TitleRepository titleRepository;

    @Test
    void decreaseQuantity() {
    //    System.out.println(titleRepository.decreaseQuantity(1));
    }
}