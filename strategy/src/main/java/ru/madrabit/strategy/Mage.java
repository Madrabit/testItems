package ru.madrabit.strategy;

class Mage extends Character {


    protected Mage(String race) {
        switch (race) {
            case "elf":
                damage = 10;
                break;
            case "human":
                damage = 4;
                break;
            case "ork":
                damage = 0;
            case "undead":
                damage = 5;
        }
    }
}
