package com.ebradev.formations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvFormation;
    private ArrayList<Formation> formations;
    private FormationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFormation = findViewById(R.id.liste_formations);
        formations = new ArrayList<>();
        adapter = new FormationAdapter(this, formations);
        lvFormation.setAdapter(adapter);

        getFormations();

    }

    private void getFormations() {
        String url = "http://10.0.2.2/oussama/formations.php";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    formations.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Formation formation = new Formation(
                                jsonObject.getString("id_formation"),
                                jsonObject.getString("titre_formation"),
                                jsonObject.getString("categorie_formation"),
                                jsonObject.getString("description_formation"),
                                jsonObject.getString("prix"),
                                jsonObject.getString("id_formateur")
                        );
                        formations.add(formation);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Internal Server Error", Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(request);
    }

}
