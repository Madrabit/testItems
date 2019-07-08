package ru.madrabit.strategy;

class Fighter extends Character {
    Fighter(String race, String name) {
        setCharName(name);
        simpleAttack = new SimpleAttack();
        switch (race) {
            case "elf":
                setDamage(15);
                setAttackName("атака мечом");
                break;
            case "human":
                setDamage(18);
                setAttackName("атака мечом");
                break;
            case "orc":
                setDamage(20);
                setAttackName("атака дубиной");
                break;
            case "undead":
                setDamage(18);
                setAttackName("удар копьем");
                break;
            default:
                setAttackName("атака");
                setDamage(0);
                break;
        }
    }
}
