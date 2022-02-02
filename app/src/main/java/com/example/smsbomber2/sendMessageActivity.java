package com.example.smsbomber2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class sendMessageActivity extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    Button sendBtn;
    Button backMenuBtn;
    EditText numeroValue;
    EditText messageValue;
    String numero2;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmesssage_layout);

        sendBtn = (Button) findViewById(R.id.button2);
        numeroValue = (EditText) findViewById(R.id.editTextPhone);
        messageValue = (EditText) findViewById(R.id.editTextTextPersonName);
        backMenuBtn = (Button) findViewById(R.id.buttonBack);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendMessage();
                //SMS BOMBER BOUCLE FOR
                /*for (i=0; i < 10; i++) {
                    sendSMSMessage();
                }*/
            }
        });

        backMenuBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mainActivity = new Intent(sendMessageActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }

    protected void sendMessage() {
        numero2 = numeroValue.getText().toString();
        message = messageValue.getText().toString();
        Log.d("test", "sendMessage");
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d("test 2", "boucle 1 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        /*
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, message, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        * */
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(numero2, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "Message bien envoyé !",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Le message n'a pas être envoyé !", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}
