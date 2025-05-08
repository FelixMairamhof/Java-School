package at.htlklu.app;

import at.htlklu.model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDaoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPlayerById() {
        Player p = PlayerDao.getPlayerById(6);
        System.out.println(p);
        Assertions.assertEquals("ruben", p.getFirstname());
    }
}