package edu.technopolis.pokemons_fighting.app;

import edu.technopolis.pokemons_fighting.core.FighterPokemon;
import edu.technopolis.pokemons_fighting.core.FightingController;
import edu.technopolis.pokemons_fighting.core.Pokemon;

public class App {

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        FightingController fightingController = new FightingController();
        FighterPokemon first = new Pokemon(fightingController);
        FighterPokemon second = new Pokemon(fightingController);

    }

}
