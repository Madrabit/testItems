package ru.madrabit.strategy;

import java.util.Iterator;
import java.util.Random;

/**
 * Calc for optimal strategy weight.
 * @author Madrabit
 */

class Strategy {

    /**
     * Main
     * @param args - args
     */

    static String[] lightRaces = new String[]{"elf", "human"};
    static String[] darkRaces = new String[]{"orc", "undead"};

    public static void main(String[] args) {
        Squad orcs = new Squad("orc");
        Squad humans = new Squad("human");
        Squad undead = new Squad("undead");

        Random rand = new Random();
        int n = rand.nextInt(1);

        int randomLight = (int) (Math.round(Math.random()));
        int randomDark = (int) (Math.round(Math.random()));

        Squad lightSquad = new Squad(lightRaces[randomLight]);
        Squad darkSquad = new Squad(darkRaces[randomDark]);

        System.out.println("Созданы два отряда: " + lightSquad.getRace() + " и " + darkSquad.getRace());

        int randomEnemy;

        for (Character character : lightSquad.squad) {
            System.out.println(character.getCharName());
            System.out.println("Персонаж " + character.getClass().getName() + " наносит удар " + character.getAttackName()
                    + " - " + character.getDamage() + " урона");

            randomEnemy = (int) (Math.random() * 4);
            character.attack(darkSquad.squad.get(randomEnemy));
            System.out.println("В лицо " + darkSquad.squad.get(randomEnemy).getClass().getName());
            System.out.println("У " + darkSquad.squad.get(randomEnemy).getClass().getName() + " осталость "
                    + darkSquad.squad.get(randomEnemy).getHp() + " hp");
            System.out.println();
        }

        Wizard wiz = (Wizard) humans.squad.get(0);
        Character fighter = humans.squad.get(6);

        System.out.println(orcs.squad.get(6).getHp());

        System.out.println(fighter.getAttackName());

        wiz.castSpell(fighter);
        fighter.attack(orcs.squad.get(6));

        System.out.println(orcs.squad.get(6).getHp());


    }

}
