package org.example;

import org.example.model.Pokemon;
import org.example.model.PokemonDetail;
import org.example.service.PokemonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PokemonService pokemonService = new PokemonService();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Pokemon> pokemon = new ArrayList<>();
        do {
            System.out.println("Let's catch some Pokemon!");
            System.out.println("1. get first group of 20");
            System.out.println("2. second group of 20");
            System.out.println("3. third group of 20");
            System.out.println("4. quit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());
            if (choice == 4) {
                break;
            }
            switch(choice) {
                case 1:
                    pokemon = pokemonService.getMorePokemon(0);
                    System.out.println(pokemon);
                    break;
                case 2:
                    pokemon = pokemonService.getMorePokemon(20);
                    System.out.println(pokemon);
                    break;
                case 3:
                    pokemon = pokemonService.getMorePokemon(40);
                    System.out.println(pokemon);
                    break;
            }
            getPokemonDetail(pokemon);
        } while (true);

    }

    private static void getPokemonDetail(List<Pokemon> pokemons) {
        System.out.print("Choose Pokemon: ");
        for (Pokemon p: pokemons) {
            System.out.println(p.getId() + "    " + p.getName());
            int id = Integer.parseInt(input.nextLine());
            PokemonDetail detail = pokemonService.getPokemonDetailById(id);
            System.out.println(detail);
        }
    }
}