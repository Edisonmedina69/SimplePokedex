package py.edu.simplepokedex;

import static py.edu.simplepokedex.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    ImageView photoImageView;

    TextView nameTextView;
    TextView speciesTextView;
    TextView typeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_detalle);

        photoImageView = findViewById(R.id.imageViewPhoto);
        nameTextView = findViewById(R.id.textViewName);
        speciesTextView = findViewById(id.textViewSpecies);
        typeTextView = findViewById(R.id.textViewType);

        //recibir el objeto pokemon seleccionado de la ListView aterior
        pokemon pokemon = (pokemon) getIntent().getSerializableExtra("pokemon");
        assert pokemon != null;
        mostrarPokemon(pokemon);
    }

    private void mostrarPokemon(pokemon pokemon) {
        Picasso.get().load("https://leodufer.github.io/simple-pokedex/img/pokemons/"+pokemon.getName().toLowerCase()+".jpg")
                .into(photoImageView);

        nameTextView.setText(pokemon.getName());
        speciesTextView.setText(pokemon.getSpecies());
        typeTextView.setText(pokemon.getType().toString());




    }
}