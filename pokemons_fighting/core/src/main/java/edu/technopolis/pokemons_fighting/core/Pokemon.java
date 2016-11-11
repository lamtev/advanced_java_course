package edu.technopolis.pokemons_fighting.core;

import static edu.technopolis.pokemons_fighting.core.ActionType.*;

public class Pokemon implements FighterPokemon {

    private int power = FighterPokemon.DEFAULT_POKEMON_POWER;
    private FightingController fightingController;
    private ActionType actionType = null;

    public Pokemon(FightingController fightingController) {
        this.fightingController = fightingController;
        fightingController.addFighter(this);
    }

    @Override
    public int getPower() {
        return power;
    }


    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void attackUsingFists() {
        power--;
        actionType = ATTACK_USING_FISTS;
        notifyFightingController(actionType);
    }

    @Override
    public void attackUsingFeet() {
        actionType = ATTACK_USING_FEET;
        power -= 2;
        notifyFightingController(actionType);
    }

    @Override
    public void defendFromFistsKick() {
        actionType = DEFENCE_FROM_FISTS;
        power--;
        notifyFightingController(actionType);
    }

    @Override
    public void defendFromFeetKick() {
        actionType = DEFENCE_FROM_FEET;
        power -= 2;
        notifyFightingController(actionType);
    }

    @Override
    public void sleep() {
        //TODO implement it
    }

    @Override
    public void eat() {
        //TODO implement it
    }

    @Override
    public void play() {
        //TODO implement it
    }

    @Override
    public void notifyFightingController(ActionType actionType) {
        fightingController.update();
    }

    @Override
    public void update() {
        power--;
    }

}
