package com.ebradev.formations;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FormationAdapter extends ArrayAdapter<Formation> {

    private Context context;
    private ArrayList<Formation> formations;

    public FormationAdapter(@NonNull Context context, ArrayList<Formation> formations) {
        super(context, R.layout.layout_formation, formations);
        this.context = context;
        this.formations = formations;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.layout_formation, parent, false);

        TextView titre = view.findViewById(R.id.titre_formation);
        TextView prix = view.findViewById(R.id.prix_formation);
        TextView categorie = view.findViewById(R.id.cat_formation);
        TextView description = view.findViewById(R.id.desc_formation);

        Formation formation = formations.get(position);

        titre.setText(formation.getTitre());
        prix.setText(formation.getPrix()+" Dhs");
        categorie.setText(formation.getCategorie());
        description.setText(formation.getDescription());

        return view;
    }
}
