package ru.madrabit.strategy;

class Wizard extends Character {
    private int buff;

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public int getBuff() {
        return buff;
    }


    protected Wizard(String race) {
        switch (race) {
            case "elf":
                setBuff(5);
                setDamage(10);
                break;
            case "human":
                setBuff(3);
                setDamage(4);
                break;
            case "ork":
                setBuff(2);
                setDamage(0);
                break;
            case "undead":
                setBuff(5);
                setDamage(5);
                break;
            default:
                setBuff(0);
                setDamage(0);
                break;
        }
    }

    public void castSpell( Character pers) {
        pers.setDamage(pers.getDamage() + getBuff());

    }

    public void castCurse( Character pers) {
        pers.setDamage(pers.getDamage() - getBuff());
    }
}
