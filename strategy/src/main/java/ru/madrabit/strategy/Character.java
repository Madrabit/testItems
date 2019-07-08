package ru.madrabit.strategy;

abstract class Character {
    private int hp = 100;
    private int damage;
    private String attackName;
    private boolean privilege;
    private String name;
    private String secondaryAttack;
    private int secondDamage;

    SimpleAttackBehavior simpleAttack;
    SpecialAttackBehavior specialAttack;

    void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    String getAttackName() {
        return attackName;
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
            setSecondDamage((int) (getSecondDamage() * 1.5));

        } else {
            damage /= 1.5;
            setSecondDamage((int) (getSecondDamage() / 1.5));
        }

        this.privilege = privilege;
    }

    public boolean getPrivilege() {
        return privilege;
    }

    public String getCharName() {
        return name;
    }

    void setCharName(String name) {
        this.name = name;
    }


    public String getSecondaryAttackName() {
        return secondaryAttack;
    }


    public int getSecondDamage() {
        return secondDamage;
    }

    void setSecondaryAttackName(String name) {
        this.secondaryAttack = name;
    }

    void setSecondDamage(int damage) {
        this.secondDamage = damage;
    }


    public void performSpecialAttack(Character enemy) {
        specialAttack.attack(enemy,  this);
    }

    public void performSimpleAttack(Character enemy) {
        simpleAttack.attack(enemy, this);
    }



}
