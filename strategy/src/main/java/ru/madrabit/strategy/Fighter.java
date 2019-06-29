package ru.madrabit.strategy;

class Fighter extends Character {
    protected Fighter(String race) {
        switch (race) {
            case "elf":
                setDamage(15);
                setAtackName("атака мечом");
                break;
            case "human":
                setDamage(18);
                setAtackName("атака мечом");
                break;
            case "orc":
                setDamage(20);
                setAtackName("атака дубиной");
                break;
            case "undead":
                setDamage(18);
                setAtackName("удар копьем");
                break;
            default:
                setAtackName("атака");
                setDamage(0);
                break;
        }
    }
}
