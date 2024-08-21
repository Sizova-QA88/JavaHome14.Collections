package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Laura", 150);
    Player player2 = new Player(2, "Michael", 70);
    Player player3 = new Player(3, "Thomas", 150);
    Player player4 = new Player(4, "Lisa", 200);

    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }


    @Test
    public void roundDraw() {
        int expected = 0;
        int actual = game.round("Laura", "Thomas");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winplayer1() {
        int expected = 1;
        int actual = game.round("Lisa", "Michael");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winPlayer2() {
        int expected = 2;
        int actual = game.round("Thomas", "Lisa");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerOneNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Linda", "Michael");
        });
    }

    @Test
    public void playerTwoNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Thomas", "John");
        });
    }

    @Test
    public void testSizeRegisteredList() {
        game.register(player3);

        Assertions.assertEquals(4, game.registeredPlayers.size());
    }
}