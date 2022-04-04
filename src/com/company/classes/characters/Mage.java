package com.company.classes.characters;

import com.company.Constants;
import com.company.classes.AttackType;
import com.company.classes.CharacterClass;
import com.company.util.AlignInteger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.company.util.AlignInteger.alignInteger;

public class Mage  extends CharacterClass {
    private final int teleportKey;
    public Mage(String name, int x, int y, int leftKey, int rightKey, int upKey, int downKey, int leftAttackKey, int rightAttackKey, int teleportKey) {
        super(name, x, y, leftKey, rightKey, upKey, downKey, leftAttackKey, rightAttackKey);

        this.setAttackType(AttackType.MAGICAL_RANGED);
        this.setMaxHealthPoints(300);
        this.setManaPoints(300);
        this.playerClass = "mage";
        this.uploadImage();
        this.setAttackAmount(70);
        this.teleportKey = teleportKey;
    }
    @Override
    public void left() {
        int newPositionX = this.getX() >= Constants.CHARACTER_IMG_WIDTH ? this.getX() - Constants.CHARACTER_IMG_WIDTH : Constants.MAX_RIGHT_POSITION;
        tryChangePosition(newPositionX, getY());

    }

    @Override
    public void right() {
        int newPositionX = this.getX() < Constants.MAX_RIGHT_POSITION ? this.getX() + Constants.CHARACTER_IMG_WIDTH : 0;
        tryChangePosition(newPositionX, getY());
    }

    @Override
    public void up() {
        int newPositionY = this.getY() < Constants.CHARACTER_IMG_HEIGHT ? Constants.MAX_RIGHT_POSITION : this.getY() - Constants.CHARACTER_IMG_HEIGHT;
        tryChangePosition(getX(), newPositionY);
    }

    @Override
    public void down() {
        int newPositionY = this.getY() < Constants.MAX_RIGHT_POSITION ? this.getY() + Constants.CHARACTER_IMG_HEIGHT : 0;
        tryChangePosition(getX(), newPositionY);
    }
    public void leftAttack() {

    }
    public void rightAttack() {

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(shouldTeleport) {
            tryChangePosition(
                alignInteger(e.getX(), Constants.CHARACTER_IMG_WIDTH),
                alignInteger(e.getY(), Constants.CHARACTER_IMG_HEIGHT)
            );
            shouldTeleport = false;
        }
    }
    private boolean shouldTeleport = false;
    @Override
    public void keyPress(int key){
        if(key == teleportKey){
            shouldTeleport = true;
        }
    }
}
