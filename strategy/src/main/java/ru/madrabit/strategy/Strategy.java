package ru.madrabit.strategy;

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

        int random = (int)(Math.round(Math.random()));

        Squad lightSquade = new Squad(lightRaces[random]);
        Squad darkSquade = new Squad(darkRaces[random]);

        System.out.println(lightSquade);
        System.out.println(darkSquade);

        Wizard wiz = (Wizard) humans.squad.get(0);
        Character fighter = humans.squad.get(6);

        System.out.println(orcs.squad.get(6).getHp());

        System.out.println(fighter.getAttackName());

        wiz.castSpell(fighter);
        fighter.attack(orcs.squad.get(6));

        System.out.println(orcs.squad.get(6).getHp());


    }

}
