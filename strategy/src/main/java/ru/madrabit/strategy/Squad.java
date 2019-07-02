package ru.madrabit.strategy;

import java.util.ArrayList;
import java.util.Iterator;

class Squad {

    final ArrayList<Character> squad;

    private String race;



    Squad(String race) {
        squad = new ArrayList<>();
        squad.add(new Wizard(race));
        squad.add(new Archer(race, "Лучник №1"));
        squad.add(new Archer(race, "Лучник №2"));
        squad.add(new Archer(race, "Лучник №3"));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));

        this.race = race;
    }

    public String getRace() {
        return race;
    }

}
