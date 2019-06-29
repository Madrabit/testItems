package ru.madrabit.strategy;

class Character {
    private int hp = 100;
    private int damage;
    private String atackName;

    public void setAtackName(String atackName) {
        this.atackName = atackName;
    }

    public String getAtackName() {
        return atackName;
    }

    public void atack( Character enemy) {
        enemy.hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
