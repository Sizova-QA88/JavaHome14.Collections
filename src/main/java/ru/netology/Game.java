package ru.netology;

import java.util.ArrayList;
import java.util.List;


public class Game {
    List<Player> registeredPlayers = new ArrayList<>();

    // метод регистрации игрока
    public void register(Player player) {
        if (!registeredPlayers.contains(player)) {
            registeredPlayers.add(player);
        }
        return;
    }

    public Player findByName(String name) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    // метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + "не зарегистрирован!");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + "не зарегистрирован!");
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }


}