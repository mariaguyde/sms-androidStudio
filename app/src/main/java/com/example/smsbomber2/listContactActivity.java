package com.example.smsbomber2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listContactActivity extends Activity {
    public List<String> contact;
    Button backMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcontact_layout);

        contact = new ArrayList<String>();
        contact.add("Jenny Milo 09 32 91 38 29");
        contact.add("Mark Bason 06 23 18 39 23");
        contact.add("Johnny Zaton 07 32 21 39 31");
        contact.add("Rosé Millie 06 11 22 33 44");

        // Adapter mon Arraylist pour l'afficher dans une list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contact);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        backMenuBtn = (Button) findViewById(R.id.btnBackMenu);
        backMenuBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mainActivity = new Intent(listContactActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }
}
