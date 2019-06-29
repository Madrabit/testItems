package ru.madrabit.strategy;

import java.util.ArrayList;

class Squad {
    private String race;

    ArrayList<Character> squad = new ArrayList<>();

    public Squad(String race) {
        this.race = race;
        squad.add(new Wizard(race));
        squad.add(new Archer());
        squad.add(new Archer());
        squad.add(new Archer());
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
    }
}
