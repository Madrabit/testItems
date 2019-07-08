package ru.madrabit.strategy;

class Wizard extends Character {

    private final boolean cast;

    Wizard(String race) {
        simpleAttack = new SimpleAttack();
        specialAttack = new SpecialAttack();
        setCharName("Волшебник");
        switch (race) {
            case "elf":
                setAttackName("выстрел из посоха");
                setDamage(5);
                setSecondaryAttackName("атаковать противника");
                cast = true;
                setDamage(10);
                break;
            case "human":
                cast = true;
                setAttackName("выстрел из посоха");
                setDamage(4);
                break;
            case "ork":
                cast = true;
                setAttackName("выстрел из посоха");
                setDamage(0);
                break;
            case "undead":
                cast = false;
                setAttackName("выстрел из посоха");
                setDamage(5);
                break;
            default:
                cast = false;
                setAttackName("выстрел из посоха");
                setDamage(0);
                break;
        }
    }

    public void castSpell(Character pers) {
        pers.setPrivilege(cast);
    }


}
