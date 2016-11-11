package edu.technopolis.pokemons_fighting.core;

import java.util.ArrayList;
import java.util.List;

public class FightingController {

    private List<FighterPokemon> fighters = new ArrayList<>(2);
    private int index = 0;

    public FighterPokemon getCurrentFighter() {
        return fighters.get(index);
    }

    public void addFighter(FighterPokemon fighter) {
        fighters.add(fighter);
    }

    public void update() {
        index = (index + 1) % 2;
    }

}
