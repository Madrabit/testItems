package ru.madrabit.strategy;

class Archer extends Character implements SecondAttack {
    private String secondaryAttack;
    private int secondDamage;
    private boolean privilege;

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
        if (privilege) {
            System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + getSecondDamage());
            System.out.println(getCharName()
                    + " наносит особый удар "
                    + getSecondaryAttackName()
                    + " - " + getSecondDamage() + " урона");
            System.out.println("В лицо " + enemy.getCharName());
            enemy.setHp(enemy.getHp() - secondDamage);

            setPrivilege(false);
            System.out.println("Персонаж стал обычным и его урон теперь составляет: " + getSecondDamage());


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
