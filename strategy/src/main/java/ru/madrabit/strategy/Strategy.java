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
        Squad attacker = lightSquad;
        Squad defender = darkSquad;

        while (attacker.squad.size() > 0 && defender.squad.size() > 0) {

            attacker = turn ? lightSquad : darkSquad;
            defender = turn ? darkSquad : lightSquad;

            System.out.println("Ходят " + attacker.getRace());
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
                        simpleAttack(character, enemy);
                    } else if (character.getClass() == Archer.class){
                        ((Archer)character).secondAttack(enemy);
                        System.out.println(character.getCharName()
                                + " наносит удар "
                                + ((Archer)character).getSecondaryAttackName()
                                + " - " + ((Archer)character).getSecondDamage() + " урона");
                        System.out.println("В лицо " + enemy.getCharName());
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
                    boolean privilege;

                    privilege = checkPrivilege(character, false);

                    System.out.println("В лицо " + enemy.getCharName() + " прилетает удар " + character.getAttackName()
                            + " силой " + character.getDamage());

                    System.out.println("У " + enemy.getCharName() + " осталость "
                            + enemy.getHp() + " hp");

                    character.attack(enemy);

                    quitePrivilege(character, privilege);

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

            turn =  turn ? false :  true;
        }

    }

    private static int randCoin() {
        Random rand = new Random();
        int n = rand.nextInt(2);
        return n;
    }

    private static void simpleAttack(Character character, Character enemy) {
        character.attack(enemy);
        System.out.println(character.getCharName()
                + " наносит удар "
                + character.getAttackName()
                + " - " + character.getDamage() + " урона");
        System.out.println("В лицо " + enemy.getCharName());
        System.out.println("У " + enemy.getCharName() + " осталость "
                + enemy.getHp() + " hp");
        System.out.println();
    }

    public static boolean checkPrivilege(Character character, boolean privilege) {
        if (character.getPrivilege()) {
            System.out.println("Персонаж в привелигерованной группе и его урон составляет: " + character.getDamage());
            return true;
        }

        return false;
    }

    public static void quitePrivilege(Character character, boolean privilege) {
        if (privilege) {

            System.out.println("Персонаж стал обычным и его урон теперь составляет: " + character.getDamage());
        }
    }

}
