package com.example.guessnumberwebb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class GuessNumberWebbApplicationTests {
    GameService g;

    @BeforeEach
    void setUp(){
        g = new GameService();
    }


    @Test
    void makeGuess() {
        g.setRandomNumber(5);
        assertEquals("Högre", g.checkInput(4));
    }
}
