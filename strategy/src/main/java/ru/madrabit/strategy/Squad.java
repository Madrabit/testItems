package ru.madrabit.strategy;

import java.util.ArrayList;
import java.util.List;

class Squad {

    final List<Character> squad;

    private final String race;

    /* TODO Сделать индвидуальные имена для персонажей*/
    Squad(String race) {
        squad = new ArrayList<>();
        squad.add(new Wizard(race));
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
