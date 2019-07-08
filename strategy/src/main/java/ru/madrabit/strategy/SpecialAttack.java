package ru.madrabit.strategy;

public class SpecialAttack implements SpecialAttackBehavior {

    @Override
    public void attack(Character enemy,  Character pers) {
        if (pers.getPrivilege()) {
            System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + pers.getSecondDamage());
            System.out.println(pers.getCharName()
                    + " наносит особый удар "
                    + pers.getSecondaryAttackName()
                    + " - " + pers.getSecondDamage() + " урона");
            System.out.println("В лицо " + enemy.getCharName());
            enemy.setHp(enemy.getHp() - pers.getSecondDamage());

            pers.setPrivilege(false);
            System.out.println("Персонаж стал обычным и его урон теперь составляет: " + pers.getSecondDamage());


        } else {
            System.out.println(pers.getCharName()
                    + " наносит особый удар "
                    + pers.getSecondaryAttackName()
                    + " - " + pers.getSecondDamage() + " урона");
            System.out.println("В лицо " + enemy.getCharName());
            enemy.setHp(enemy.getHp() - pers.getSecondDamage());
        }

    }



}
