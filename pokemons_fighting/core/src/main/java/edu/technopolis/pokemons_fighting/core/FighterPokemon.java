package edu.technopolis.pokemons_fighting.core;

public interface FighterPokemon extends JustPokemon {

    int DEFAULT_POKEMON_POWER = 100;
    void attackUsingFists();
    void attackUsingFeet();
    void defendFromFistsKick();
    void defendFromFeetKick();
    void notifyFightingController(ActionType actionType);
}
