package ru.madrabit.strategy;

class Archer extends Character {
    private String secondaryAttack;
    private int secondDamage;

    Archer(String race, String name) {
        setCharName(name);
        switch (race) {
            case "elf":
                setDamage(7);
                setAttackName("стрелять из лука");
                setSecondDamage(5);
                setSecondaryAttackName("атаковать противника");
                break;
            case "human":
                setDamage(5);
                setAttackName("стрелять из арбалета");
                setSecondDamage(3);
                setSecondaryAttackName("атаковать");
                break;
            case "orc":
                setDamage(3);
                setAttackName("стрелять из лука");
                setSecondDamage(2);
                setSecondaryAttackName("удар клинком");
                break;
            case "undead":
                setDamage(4);
                setAttackName("стрелять из лука");
                setSecondDamage(2);
                setSecondaryAttackName("атаковать");
                break;
            default:
                setDamage(0);
                setAttackName("атака");
                setSecondDamage(0);
                setSecondaryAttackName("атаковать противника");
                break;
        }
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
