package ru.madrabit.strategy;

/**
 * Calc for optimal strategy weight.
 * @author Madrabit
 */

class Strategy {

    /**
     * Main
     * @param args - args
     */

    public static void main(String[] args) {
        Squad orcs = new Squad("orc");
        Squad humans = new Squad("human");
        Squad undead = new Squad("undead");

        Wizard wiz = (Wizard) humans.squad.get(0);
        Character fighter = humans.squad.get(6);

        System.out.println(orcs.squad.get(6).getHp());

        System.out.println(fighter.getAttackName());

        wiz.castSpell(fighter);
        fighter.attack(orcs.squad.get(6));

        System.out.println(orcs.squad.get(6).getHp());


    }

}
