package ru.madrabit.strategy;

class Wizard extends Character {

    private final boolean cast;
    private String secondaryAttack;
    private int secondDamage;

    Wizard(String race, String name) {
        setCharName(name);
        switch (race) {
            case "elf":
                setAttackName("стрелять из лука");
                setSecondDamage(5);
                setSecondaryAttackName("атаковать противника");
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

    public void castSpell(Character pers) {
        pers.setPrivilege(cast);
    }

    void setSecondaryAttackName(String name) {
        this.secondaryAttack = name;
    }

    public String getSecondaryAttackName() {
        return secondaryAttack;
    }

    public void setSecondDamage(int damage) {
        this.secondDamage = damage;
    }

    public int getSecondDamage() {
        return secondDamage;
    }

    public void secondAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - secondDamage);
    }
}
