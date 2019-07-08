package ru.madrabit.strategy;

public class SimpleAttack implements SimpleAttackBehavior {

    public void attack(Character enemy, Character pers) {

        if (pers.getPrivilege()) {
            System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + pers.getDamage());

            enemy.setHp(enemy.getHp() - pers.getDamage());

            System.out.println("В лицо " + enemy.getCharName() + " прилетает удар " + pers.getAttackName()
                    + " силой " + pers.getDamage());
            pers.setPrivilege(false);
            System.out.println("Персонаж стал обычным и его урон теперь составляет: " + pers.getDamage());


        } else {
            enemy.setHp(enemy.getHp() - pers.getDamage());
            System.out.println(pers.getCharName()
                    + " наносит удар "
                    + pers.getAttackName()
                    + " - " + pers.getDamage() + " урона");
            System.out.println("В лицо " + enemy.getCharName());
        }

        System.out.println("У " + enemy.getCharName() + " осталость "
                + enemy.getHp() + " hp");
        System.out.println();


    }

}
