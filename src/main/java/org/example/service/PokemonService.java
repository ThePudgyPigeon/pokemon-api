package org.example.service;

import org.example.model.Pokemon;
import org.example.model.PokemonDetail;
import org.example.model.Results;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PokemonService {

    private RestTemplate restTemplate = new RestTemplate();

    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";


    //this returns the first 20 pokemon
    public List<Pokemon> getPokemon() {
        //do a null check
        Results results = restTemplate.getForObject(API_URL, Results.class);
        return results.getResults();
    }

    public List<Pokemon> getMorePokemon(int startValue) {
        Results results = restTemplate.getForObject(API_URL +
                "?offset=" + startValue +"&limit=20", Results.class);
        List<Pokemon> list = results.getResults();
        for(Pokemon item: list) {
            String url = item.getUrl(); //get url so we can pull index
            int pokemonIndex = url.indexOf("pokemon"); //index of the word pokemon
            String pokemonString = url.substring(pokemonIndex); // "pokemon/number/"
            int slashIndex = pokemonString.indexOf("/"); // the index of '/'number"
            String number = pokemonString.substring(slashIndex + 1, pokemonString.length() - 1); //removes slashes
            int id = Integer.parseInt(number);
            item.setId(id);
        }
        return list;
    }

    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail detail = restTemplate.getForObject(API_URL + "/" + id, PokemonDetail.class);

        return detail;
    }

}
