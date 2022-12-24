package com.game.allgames;

import org.springframework.stereotype.Component;

@Component
public class HitmanGame implements GamingConsole {

    public void up() {
        System.out.println("Hitman jump");
    }

    public void down() {
        System.out.println("Hitman down into the house");
    }

    public void left() {
        System.out.println("Hitman stop");
    }

    public void right() {
        System.out.println("Hitman accelerate");
    }
}
