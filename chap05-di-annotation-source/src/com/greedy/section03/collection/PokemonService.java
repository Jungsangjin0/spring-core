package com.greedy.section03.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	private List<pokemon> pokemon;
	
	@Autowired
	public PokemonService(List<pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		for(pokemon pokemon : pokemon) {
			pokemon.attack();
		}
	}
	
}
