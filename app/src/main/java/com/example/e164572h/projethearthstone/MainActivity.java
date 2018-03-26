package com.example.e164572h.projethearthstone;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        Spinner spinnerClasse = (Spinner) findViewById(R.id.spinnerClasse);
        Spinner spinnerType = (Spinner) findViewById(R.id.spinnerType);
        Spinner spinnerFaction = (Spinner) findViewById(R.id.spinnerFaction);
        Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerRace);
        //exemple adapter
        Integer [] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, data);
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
}
