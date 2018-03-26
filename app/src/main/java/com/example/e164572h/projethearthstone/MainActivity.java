package com.example.e164572h.projethearthstone;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.*;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///florian daniel
    }

    public void gestionSpinner(View v) {
        final Spinner spinnerClasse = (Spinner) findViewById(R.id.spinnerClasse);
        final Spinner spinnerType = (Spinner) findViewById(R.id.spinnerType);
        final Spinner spinnerFaction = (Spinner) findViewById(R.id.spinnerFaction);
        final Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerRace);
        //exemple adapter
        Integer [] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, data);
        spinnerClasse.setAdapter(adapter);

        spinnerClasse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = spinnerClasse.getSelectedItem().toString();
                versVueList(data);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = spinnerType.getSelectedItem().toString();
                versVueList(data);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spinnerFaction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = spinnerFaction.getSelectedItem().toString();
                versVueList(data);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spinnerRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = spinnerRace.getSelectedItem().toString();
                versVueList(data);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    public void jsonVolley(View v) {
        final String url = "https://nosql-workshop.herokuapp.com/api/installations/random";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                String s = "";
                try {

                    JSONObject repObj = (JSONObject) new JSONTokener(response).nextValue();
                    Log.e("json", repObj.toString());
                    s += repObj.getString("nom") + "\n";
                    JSONObject adresse = repObj.getJSONObject("adresse");
                    s+= adresse.getString("numero") + " " + adresse.getString("voie") + "\n" + adresse.getString("codePostal") + " " + adresse.getString("commune");
                } catch (JSONException je) {
                    Log.e("test JSON", je.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nom", "BOIX");
                return params;
            }
        };
        queue.add(stringRequest);
    }

    public void versVueList(String data) {
        Intent versVueList = new Intent(MainActivity.this, ListActivity.class);
        versVueList.putExtra(Intent.EXTRA_TEXT, data);
        startActivity(versVueList);
    }
}
