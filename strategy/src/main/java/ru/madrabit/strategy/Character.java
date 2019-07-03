package ru.madrabit.strategy;

class Character {
    private int hp = 100;
    private int damage;
    private String attackName;
    private boolean privilege;
    private String name;

    void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    String getAttackName() {
        return attackName;
    }

    void attack(Character enemy) {
        if (privilege) {

            enemy.hp = enemy.hp - damage;
            setPrivilege(false);

        } else {
            enemy.hp = enemy.hp - damage;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    void setDamage(int damage) {

        this.damage = damage;
    }

    int getDamage() {
        return damage;
    }

    public void setPrivilege(boolean privilege) {
        if (privilege) {
            damage *= 1.5;

        } else {
            damage /= 1.5;
        }

        this.privilege = privilege;
    }

    public boolean getPrivilege() {
        return privilege;
    }

    public String getCharName() {
        return name;
    }

    public void setCharName(String name) {
        this.name = name;
    }
}
