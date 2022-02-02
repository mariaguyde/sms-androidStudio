package com.example.smsbomber2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    Button contactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Bouton Envoyer un message
        sendBtn = (Button) findViewById(R.id.btnsendMessage);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // renvoi vers l'activité en question
                Intent sendMessageActivity = new Intent(MainActivity.this, sendMessageActivity.class);
                startActivity(sendMessageActivity);
            }
        });

        // Bouton Liste des contact
        contactBtn = (Button) findViewById(R.id.contactListBtn);
        contactBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent listContactActivity = new Intent(MainActivity.this, listContactActivity.class);
                startActivity(listContactActivity);
            }
        });


    }
}