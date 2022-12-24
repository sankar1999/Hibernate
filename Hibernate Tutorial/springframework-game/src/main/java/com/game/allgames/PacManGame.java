package com.game.allgames;

import org.springframework.stereotype.Component;

public class PacManGame implements GamingConsole {

    public void up() {
        System.out.println("PacManGame jump");
    }

    public void down() {
        System.out.println("PacManGame down into the house");
    }

    public void left() {
        System.out.println("PacManGame stop");
    }

    public void right() {
        System.out.println("PacManGame accelerate");
    }
}
