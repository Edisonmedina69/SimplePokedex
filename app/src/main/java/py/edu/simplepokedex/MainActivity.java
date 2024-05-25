package py.edu.simplepokedex;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<pokemon>> {

    ListView pokemonListView;
    ProgressBar progressBar;
    TextView errorTextView;
    PokemonService service;

    Button buttonReintentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonListView = findViewById(R.id.listViewPokemon);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.textViewError);
        buttonReintentar = findViewById(R.id.buttonReintentar);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.end_point))
                .build();
        service = restAdapter.create(PokemonService.class);
        service.getpokemos(this);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pokemon p = (pokemon) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("pokemon",p);
                startActivity(intent);

            }
        });
    }

    @Override
    public void success(List<pokemon> pokemons, Response response) {
        progressBar.setVisibility(View.GONE);
        PokemonAdpater adpater = new PokemonAdpater(this,pokemons);
        pokemonListView.setAdapter(adpater);
        pokemonListView.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
    }


    @Override
    public void failure(RetrofitError error) {
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.error_al_obtener_los_pokemones);
        buttonReintentar.setVisibility(View.VISIBLE);

        Log.e("ERROR",error.getLocalizedMessage());

       }


    public void Reintentar(View view) {
        buttonReintentar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        service.getpokemos(this);
    }
}