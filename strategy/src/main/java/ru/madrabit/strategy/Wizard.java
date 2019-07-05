package ru.madrabit.strategy;

class Wizard extends Character implements SecondAttack {

    private final boolean cast;
    private String secondaryAttack;
    private int secondDamage;
    private boolean privilege;

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
        if (privilege) {
            System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + getDamage());
            enemy.setHp(enemy.getHp() - secondDamage);
            System.out.println("Персонаж стал обычным и его урон теперь составляет: " + getDamage());
            setPrivilege(false);
        } else {
            enemy.setHp(enemy.getHp() - secondDamage);
        }
    }

    @Override
    public void setPrivilege(boolean privilege) {
        if (privilege) {
            setDamage((int) (getDamage() * 1.5));
            setSecondDamage((int) (getSecondDamage() * 1.5));

        } else {
            setDamage((int) (getDamage() / 1.5));
            setSecondDamage((int) (getSecondDamage() / 1.5));
        }

        this.privilege = privilege;
    }
}
