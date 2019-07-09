package ru.madrabit.strategy;

public class SpecialAttack implements SpecialAttackBehavior {

    StringBuffer output =  new StringBuffer();

    @Override
    public StringBuffer attack(Character enemy,  Character pers) {
        if (pers.getPrivilege()) {
            output.append("Персонаж в привелигерованной группе и его урон составляет: " + pers.getSecondDamage()
            + "\n"  + pers.getCharName()
                    + " наносит особый удар "
                    + pers.getSecondaryAttackName()
                    + " - " + pers.getSecondDamage() + " урона"
                    + "В лицо " + enemy.getCharName() + "\n");
            enemy.setHp(enemy.getHp() - pers.getSecondDamage());

            pers.setPrivilege(false);
            output.append("Персонаж стал обычным и его урон теперь составляет: " + pers.getSecondDamage() + "\n");


        } else {
            output.append(pers.getCharName()
                    + " наносит особый удар "
                    + pers.getSecondaryAttackName()
                    + " - " + pers.getSecondDamage() + " урона"
                    + "В лицо " + enemy.getCharName() + "\n");
            enemy.setHp(enemy.getHp() - pers.getSecondDamage());
        }

        return output;

    }



}
