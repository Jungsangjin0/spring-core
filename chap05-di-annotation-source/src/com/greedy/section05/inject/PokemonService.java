package com.greedy.section05.inject;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {

	//	@Autowired
	//	@Inject
	//	@Qualifier("pikachu")
	//	@Named("pikachu")
	private pokemon pokemon;

	//	@Autowired
//	@Inject
//	@Named("pikachu")
//	public PokemonService(pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	

	@Inject
	@Named("pikachu")
	public void setPokemon(pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public void pokemonAttack() {
		pokemon.attack();
	}
}
