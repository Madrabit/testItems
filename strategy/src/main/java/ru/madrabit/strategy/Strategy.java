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


    private static final String[] LIGHT = new String[]{"elf", "human"};
    private static final String[] DARK = new String[]{"orc", "undead"};

    public static void main(String[] args) throws IOException {



        StringBuffer output =  new StringBuffer();

        int randomLight = (int) (Math.round(Math.random()));
        int randomDark = (int) (Math.round(Math.random()));

        Squad lightSquad = new Squad(LIGHT[randomLight]);
        Squad darkSquad = new Squad(DARK[randomDark]);

        boolean turn = false;
        Squad attacker = lightSquad;
        Squad defender = darkSquad;
        int move = 0;
        int randomEnemy;

        /* TODO Сделать чтобы нормальные названия были на русском у отрядов */
        output.append("\n"
                + "Созданы два отряда: " + lightSquad.getRace() + " и " + darkSquad.getRace()
                + "\n");


        while (attacker.squad.size() > 0 && defender.squad.size() > 0) {

            attacker = turn ? lightSquad : darkSquad;
            defender = turn ? darkSquad : lightSquad;

            output.append("\n"
                    + "Ходят " + attacker.getRace() + "\n"
                    + "Ход №" + ++move
                    + "\n\n");


            for (Character character : attacker.squad) {
                if (defender.squad.size() == 0) {
                    break;
                }

                output.append(character.getCharName() + "\n");


                randomEnemy = (int) (Math.random() * defender.squad.size());
                Character enemy = defender.squad.get(randomEnemy);

                if (!(character instanceof Fighter)) {

                    int n = randCoin();

                    if (n == 0) {
                        output.append(character.performSimpleAttack(enemy) + "\n");
                    } else if (character instanceof Archer) {
                        output.append("Спец атака лучника" + "\n");
                        character.performSpecialAttack(enemy);

                        output.append("У " + enemy.getCharName() + " осталость "
                                + enemy.getHp() + " hp" + "\n\n");

                    } else {

                        int randomFriend = (int) (Math.random() * attacker.squad.size());
                        Character friend = attacker.squad.get(randomFriend);
                        ((Wizard) character).castSpell(friend);

                        output.append(character.getCharName()
                                + " накладывает усиление на "
                                + friend.getCharName()
                                + " и его урон становится равен " + friend.getDamage() + " урона" + "\n\n");
                    }
                } else {
                    output.append(character.performSimpleAttack(enemy));

                }


                if (enemy.getHp() <= 0) {
                    output.append(enemy.getCharName() + " - Убит!" + "\n\n");
                    defender.squad.remove(enemy);
                }

            }



            if (defender.squad.size() == 0) {
                output.append("Все " + defender.getRace() + " мертвы"
                        + "\n\n"
                        + "Победили " + attacker.getRace() + "\n");
                break;
            } else {
                output.append("Статистика здоровья врага " + defender.getRace() + " :" + "\n");

                for (Character character : defender.squad) {
                    output.append(character.getCharName() + " : " + character.getHp() + "\n");
                }
            }

            output.append("\n");

            turn =  !turn;
        }


        BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("out.txt")));
        buffer.write(output.toString());

        buffer.flush();
        buffer.close();

        System.out.println(output);


    }

    private static int randCoin() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

}
