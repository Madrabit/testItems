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

        int randomLight = (int) (Math.round(Math.random()));
        int randomDark = (int) (Math.round(Math.random()));

        Squad lightSquad = new Squad(lightRaces[randomLight]);
        Squad darkSquad = new Squad(darkRaces[randomDark]);

        /* TODO Сделать чтобы нормальные названия были на русском у отрядов */
        System.out.println("Созданы два отряда: " + lightSquad.getRace() + " и " + darkSquad.getRace());

        int randomEnemy;


        /* TODO Сделать через Итератор
        *  TODO реализовать метод мага *1.5 к дамагу
        *  TODO вызов рандомного выбора атаки у перса
        *  TODO если у перса HP меньше 0 убрать его из сквада
        *
        * */

        boolean turn = false;
        Squad firstSquad = lightSquad;
        Squad secondSquad = darkSquad;

        while (firstSquad.squad.size() > 0 && secondSquad.squad.size() > 0) {

            firstSquad = turn ? lightSquad : darkSquad;
            secondSquad = turn ? darkSquad : lightSquad;

            System.out.println("Ходят " + firstSquad.getRace());
            System.out.println();

            for (Character character : firstSquad.squad) {
                if (secondSquad.squad.size() == 0) {
                    break;
                }

                System.out.println(character.getCharName());


                randomEnemy = (int) (Math.random() * secondSquad.squad.size());
                Character enemy = secondSquad.squad.get(randomEnemy);

                if (character.getClass() == Wizard.class) {
                    Random rand = new Random();
                    int n = rand.nextInt(2);
                    if (n == 0) {
                        character.attack(enemy);
                        System.out.println("Колдун " + character.getCharName()
                                + " наносит удар "
                                + character.getAttackName()
                                + " - " + character.getDamage() + " урона");
                        System.out.println("В лицо " + enemy.getCharName());
                        System.out.println("У " + enemy.getCharName() + " осталость "
                                + enemy.getHp() + " hp");
                        System.out.println();
                    } else {
                        ((Wizard) character).castSpell(enemy);
                        int randomFriend = (int) (Math.random() * firstSquad.squad.size());
                        Character friend = firstSquad.squad.get(randomFriend);
                        System.out.println(character.getCharName()
                                + " накладывает усиление на "
                                + friend.getCharName()
                                + " и его урон становится равен " + friend.getDamage() + " урона");
                        System.out.println();
                    }

                } else {
                    boolean privilege = false;
                    if (character.getPrivilege()) {
                        System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + character.getDamage());
                        privilege = true;
                    }


                    System.out.println("В лицо " + enemy.getCharName() + " прилетает удар " + character.getAttackName()
                            + " c cилой " + character.getDamage());

                    System.out.println("У " + enemy.getCharName() + " осталость "
                            + enemy.getHp() + " hp");

                    character.attack(enemy);

                    if (privilege) {

                        System.out.println("Персонаж стал обычным и его урон теперь составляет: " + character.getDamage());
                    }
                    System.out.println();
                }


                if (enemy.getHp() <= 0) {
                    System.out.println(enemy.getCharName() + " - Убит!");
                    secondSquad.squad.remove(enemy);

                }

            }



            if (secondSquad.squad.size() == 0) {
                System.out.println("Все " + secondSquad.getRace() + " мертвы");
                System.out.println("Победили " + firstSquad.getRace());
                break;
            } else {
                System.out.println("Статистика здоровья врага " + secondSquad.getRace() + " :");

                for (Character character : secondSquad.squad) {
                    System.out.println(character.getCharName() + " : " + character.getHp());
                }
            }

            System.out.println();

            turn =  turn ? false :  true;
        }

    }

}
