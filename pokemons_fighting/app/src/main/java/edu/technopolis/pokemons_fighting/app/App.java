package edu.technopolis.pokemons_fighting.app;

import edu.technopolis.pokemons_fighting.core.FighterPokemon;
import edu.technopolis.pokemons_fighting.core.FightingController;
import edu.technopolis.pokemons_fighting.core.Pokemon;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        FightingController fightingController = new FightingController();
        FighterPokemon first = new Pokemon(fightingController);
        FighterPokemon second = new Pokemon(fightingController);
        Random random = new Random(System.currentTimeMillis());
        int magic;
        while(first.getPower() > 0 && second.getPower() > 0) {
            magic = Math.abs(random.nextInt()) % 4;
            switch (magic) {
                case 0:
                    first.attackUsingFeet();
                    break;
                case 1:
                    first.attackUsingFists();
                    break;
                case 2:
                    first.defendFromFeetKick();
                    break;
                case 3:
                    first.defendFromFistsKick();
                    break;
            }
            System.out.println();
            System.out.println("Pokemon 1");
            System.out.println("Power: " + first.getPower());
            System.out.println("Action: " + first.getActionType().name());
            System.out.println();

            magic = Math.abs(random.nextInt()) % 4;
            switch (magic) {
                case 0:
                    second.attackUsingFeet();
                    break;
                case 1:
                    second.attackUsingFists();
                    break;
                case 2:
                    second.defendFromFeetKick();
                    break;
                case 3:
                    second.defendFromFistsKick();
                    break;
            }
        }
        System.out.println();
        System.out.println("Pokemon 2");
        System.out.println("Power: " + second.getPower());
        System.out.println("Action: " + first.getActionType().name());
        System.out.println();
    }

}
