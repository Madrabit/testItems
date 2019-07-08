package ru.madrabit.strategy;

import java.util.Random;
import java.io.*;

/**
 * Calc for optimal strategy weight.
 * @author Madrabit
 */

class Strategy {

    /**
     * Main
     * @param args - args
     */


    private static final String[] lightRaces = new String[]{"elf", "human"};
    private static final String[] darkRaces = new String[]{"orc", "undead"};

    public static void main(String[] args) throws FileNotFoundException  {

        PrintStream fileOut = new PrintStream(new FileOutputStream("out.txt"));
        System.setOut(fileOut);

        int randomLight = (int) (Math.round(Math.random()));
        int randomDark = (int) (Math.round(Math.random()));

        Squad lightSquad = new Squad(lightRaces[randomLight]);
        Squad darkSquad = new Squad(darkRaces[randomDark]);

        boolean turn = false;
        Squad attacker = lightSquad;
        Squad defender = darkSquad;
        int move = 0;
        int randomEnemy;

        /* TODO Сделать чтобы нормальные названия были на русском у отрядов */

        System.out.println();
        System.out.println("Созданы два отряда: " + lightSquad.getRace() + " и " + darkSquad.getRace());
        System.out.println();


        while (attacker.squad.size() > 0 && defender.squad.size() > 0) {

            attacker = turn ? lightSquad : darkSquad;
            defender = turn ? darkSquad : lightSquad;


            System.out.println("Ходят " + attacker.getRace());
            System.out.println("Ход №" + ++move);
            System.out.println();

            for (Character character : attacker.squad) {
                if (defender.squad.size() == 0) {
                    break;
                }

                System.out.println(character.getCharName());


                randomEnemy = (int) (Math.random() * defender.squad.size());
                Character enemy = defender.squad.get(randomEnemy);

                if (!(character.getClass() == Fighter.class)) {

                    int n = randCoin();

                    if (n == 0) {
                        character.performSimpleAttack(enemy);
                    } else if (character.getClass() == Archer.class) {
                        System.out.println("Спец атака лучника");
                        character.performSpecialAttack(enemy);

                        System.out.println("У " + enemy.getCharName() + " осталость "
                                + enemy.getHp() + " hp");
                        System.out.println();
                    } else {

                        int randomFriend = (int) (Math.random() * attacker.squad.size());
                        Character friend = attacker.squad.get(randomFriend);
                        ((Wizard) character).castSpell(friend);

                        System.out.println(character.getCharName()
                                + " накладывает усиление на "
                                + friend.getCharName()
                                + " и его урон становится равен " + friend.getDamage() + " урона");

                        System.out.println();
                    }
                } else {

//                    character.attack(enemy);
                    character.performSimpleAttack(enemy);
                    System.out.println("У " + enemy.getCharName() + " осталость "
                            + enemy.getHp() + " hp");

                    System.out.println();
                }


                if (enemy.getHp() <= 0) {
                    System.out.println(enemy.getCharName() + " - Убит!");
                    defender.squad.remove(enemy);

                }

            }



            if (defender.squad.size() == 0) {
                System.out.println("Все " + defender.getRace() + " мертвы");
                System.out.println("Победили " + attacker.getRace());
                break;
            } else {
                System.out.println("Статистика здоровья врага " + defender.getRace() + " :");

                for (Character character : defender.squad) {
                    System.out.println(character.getCharName() + " : " + character.getHp());
                }
            }

            System.out.println();

            turn =  !turn;
        }

        System.setOut(System.out);
        System.out.println();


    }

    private static int randCoin() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

}
