package ru.madrabit.strategy;

import java.util.ArrayList;

class Squad {

    final ArrayList<Character> squad;

    Squad(String race) {
        squad = new ArrayList<>();
        squad.add(new Wizard(race));
        squad.add(new Archer(race));
        squad.add(new Archer(race));
        squad.add(new Archer(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
        squad.add(new Fighter(race));
    }
}
