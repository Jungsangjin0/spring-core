package com.greedy.section04.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class PokemonService {
	
	//bean의 타입이 아닌 id로 매칭시킨다.
//	@Resource(name ="charmander")
//	@Qualifier("charmander")
	private pokemon pokemon;
	
//	public PokemonService(pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
//	@Resource(name = "charmander")
//	public void setPokemon(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
	
}
