package py.edu.simplepokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdpater extends BaseAdapter {

    private Context context;
    private List<pokemon> pokemons;

    public PokemonAdpater(Context context, List<pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pokemons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
           view = LayoutInflater.from(context).inflate(R.layout.item_pokemon,null);
        }
        pokemon pokemon = (pokemon) getItem(position);
        ImageView imgImageView = view.findViewById(R.id.imageViewImg);
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView speciesTextView = view.findViewById(R.id.textViewSpecies);
        nameTextView.setText(pokemon.getName());
        speciesTextView.setText(pokemon.getSpecies());
        Picasso.get().load("https://leodufer.github.io/simple-pokedex/img/pokemons/"+pokemon.getName().toLowerCase()+".jpg")
                .into(imgImageView);




        return view;
    }
}
