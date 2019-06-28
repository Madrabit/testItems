package ru.madrabit.strategy;

class Squad {
    private String race;


    public Squad (String race) {
        this.race = race;
        Character mage = new Mage(race);
        Character arch_1 = new Archer();
        Character arch_2 = new Archer();
        Character arch_3 = new Archer();
        Character fighter_1 = new Fighter();
        Character fighter_2 = new Fighter();
        Character fighter_3 = new Fighter();
        Character fighter_4 = new Fighter();
    }
}
