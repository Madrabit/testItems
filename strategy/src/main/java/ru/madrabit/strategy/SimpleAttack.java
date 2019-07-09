package ru.madrabit.strategy;

public class SimpleAttack implements SimpleAttackBehavior {

    StringBuffer output =  new StringBuffer();

    public StringBuffer attack(Character enemy, Character pers) {

        if (pers.getPrivilege()) {
            output.append("Персонаж в привелигерованной группе и его урон составляет: " + pers.getDamage() + "\n");

            enemy.setHp(enemy.getHp() - pers.getDamage());

            output.append("В лицо " + enemy.getCharName() + " прилетает удар " + pers.getAttackName()
                    + " силой " + pers.getDamage() + "\n");
            pers.setPrivilege(false);
            output.append("Персонаж стал обычным и его урон теперь составляет: " + pers.getDamage() + "\n");


        } else {
            enemy.setHp(enemy.getHp() - pers.getDamage());
            output.append(pers.getCharName()
                    + " наносит удар "
                    + pers.getAttackName()
                    + " - " + pers.getDamage() + " урона" + "\n");
            output.append("В лицо " + enemy.getCharName() + "\n");
        }

        output.append("У " + enemy.getCharName() + " осталость "
                + enemy.getHp() + " hp" + "\n\n");

        return output;

    }

}
