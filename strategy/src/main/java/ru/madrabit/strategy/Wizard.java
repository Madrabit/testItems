package ru.madrabit.strategy;

class Wizard extends Character {

    private final boolean cast;

    Wizard(String race, String name) {
        setCharName(name);
        switch (race) {
            case "elf":
                cast = true;
                setDamage(10);
                break;
            case "human":
                cast = true;
                setDamage(4);
                break;
            case "ork":
                cast = true;
                setDamage(0);
                break;
            case "undead":
                cast = false;
                setDamage(5);
                break;
            default:
                cast = false;
                setDamage(0);
                break;
        }
    }

    void castSpell(Character pers) {
        pers.setPrivilege(cast);
    }
}
