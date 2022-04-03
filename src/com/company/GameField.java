package com.company;

import com.company.classes.CharacterClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel {
    private Team team;
    private CharacterClass[] players;
    public GameField(Team team) {
        this.team = team;
        this.players = team.getTeamMembers();

        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (CharacterClass player : players) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
            g.drawString("" + player.getHealthPoints(), player.getX(), player.getY() + 12);
            g.drawString("∞", player.getX(), player.getY() + 26);
        }
    }

    public class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            for (CharacterClass player : players) {
                if (key == player.leftKey) {
                    player.left();
                }
                if (key == player.rightKey) {
                    player.right();
                }
                if (key == player.upKey) {
                    player.up();
                }
                if (key == player.downKey) {
                    player.down();
                }
                if (key == player.leftAttackKey) {
                    player.setAttackLeftImage();
                    if (player.getX() >= Constants.CHARACTER_IMG_WIDTH) {
                        int neighbourId = CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_IMG_WIDTH][player.getY()];
                        if (neighbourId > 0){
                            player.attack(players[neighbourId - 1]);
                        }
                    }

                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
                if (key == player.rightAttackKey) {
                    player.setAttackRightImage();
                    if (player.getX() <Constants.MAX_RIGHT_POSITION) {
                        int neighbourId = CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_IMG_WIDTH][player.getY()];
                        if (neighbourId > 0){
                            player.attack(players[neighbourId - 1]);
                        }
                    }
                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
            }
            repaint();
        }
    }
}
