package com.example.e164572h.projethearthstone;

import android.content.Intent;
import android.os.Bundle;
import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by E164572H on 26/03/18.
 */

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();

        String data = extras.getString(Intent.EXTRA_TEXT);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(data);

        String [] data1 = { " lorem " ," ipsum " ," dolor " ," sit " ," amet " ," consectetur " ," adipiscing " ," elit " ,
                " sed " ," do " ," eiusmod " ," tempor " ," incididunt " ," ut " ," labore " ," et " ," dolore " ,
                " magna " ," aliqua " ," ut " ," enim " ," ad " ," minim " ," veniam " ," quis " ,
                " nostrud " ," exercitation " ," ullamco " ," laboris " ," nisi " ," ut " ,
                " aliquip " ," ex " ," ea " ," commodo " ," consequat " };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }
}
