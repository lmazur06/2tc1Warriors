package com.company.classes.characters;

import com.company.classes.AttackType;
import com.company.classes.CharacterClass;

public class Mage  extends CharacterClass {

    public Mage(String name, int x, int y, int leftKey, int rightKey, int upKey, int downKey, int leftAttackKey, int rightAttackKey) {
        super(name, x, y, leftKey, rightKey, upKey, downKey, leftAttackKey, rightAttackKey);
        this.setLevel(1);
        this.setMaxHealthPoints(1000);
        this.setHealthPoints(1000);
        this.setManaPoints(200);
        this.setMaxManaPoints(200);
        this.setAttackType(AttackType.PHYSICAL);
        this.setAttackAmount(5);
        this.setName(name);

        this.setX(300);
        this.setY(0);
        this.uploadImage("1.png", "2.png", "3.png");
    }

    public void left() {

    }
    public void right() {

    }
    public void up() {

    }
    public void down() {

    }
    public void leftAttack() {

    }
    public void rightAttack() {

    }
}
