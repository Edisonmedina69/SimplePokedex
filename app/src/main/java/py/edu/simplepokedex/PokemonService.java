package py.edu.simplepokedex;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface PokemonService {

    @GET("/pokemons.json")
    void getpokemos(Callback<List<pokemon>> callback);

}
