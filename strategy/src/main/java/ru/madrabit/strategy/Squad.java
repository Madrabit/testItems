package ru.madrabit.strategy;

import java.util.ArrayList;
import java.util.Iterator;

class Squad {

    final ArrayList<Character> squad;

    private String race;


    /* TODO Сделать индвидуальные имена для персонажей*/
    Squad(String race) {
        squad = new ArrayList<>();
        squad.add(new Wizard(race, "Волшебник"));
        squad.add(new Archer(race, "Лучник №1"));
        squad.add(new Archer(race, "Лучник №2"));
        squad.add(new Archer(race, "Лучник №3"));
        squad.add(new Fighter(race, "Воин №1"));
        squad.add(new Fighter(race, "Воин №2"));
        squad.add(new Fighter(race, "Воин №3"));
        squad.add(new Fighter(race, "Воин №4"));

        this.race = race;
    }

    public String getRace() {
        return race;
    }

}
