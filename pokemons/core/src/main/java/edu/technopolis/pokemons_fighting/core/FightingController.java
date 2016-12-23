package edu.technopolis.pokemons_fighting.core;

import java.util.ArrayList;
import java.util.List;

import static edu.technopolis.pokemons_fighting.core.ActionType.*;

public class FightingController {

    private List<FighterPokemon> fighters = new ArrayList<>(2);
    private int index = 0;

    public FighterPokemon getCurrentFighter() {
        return fighters.get(index);
    }
    public FighterPokemon getPreviousFighter() {
        return fighters.get((index + 1) % 2);
    }

    public void addFighter(FighterPokemon fighter) {
        fighters.add(fighter);
    }

    public void update() {
        switch (getCurrentFighter().getActionType()) {
            case DEFENCE_FROM_FEET:
                if (getPreviousFighter().getActionType() != null &&
                        !getPreviousFighter().getActionType().equals(ATTACK_USING_FEET)) {
                    getPreviousFighter().update();
                }
                break;
            case DEFENCE_FROM_FISTS:
                if (getPreviousFighter().getActionType() != null &&
                        !getPreviousFighter().getActionType().equals(ATTACK_USING_FISTS)) {
                    getPreviousFighter().update();
                }
                break;
            default:
                break;
        }
        index++;
        index %= 2;
    }

}
