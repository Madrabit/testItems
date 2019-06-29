package ru.madrabit.strategy;

class Character {
    private int hp = 100;
    private int damage;
    private String attackName;

    void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    String getAttackName() {
        return attackName;
    }

    void attack(Character enemy) {
        enemy.hp -= damage;
    }

    int getHp() {
        return hp;
    }

    void setDamage(int damage) {
        this.damage = damage;
    }

    int getDamage() {
        return damage;
    }
}
