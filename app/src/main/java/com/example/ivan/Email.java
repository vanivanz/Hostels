package com.example.ivan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends AppCompatActivity {
    Button sendButton;
    EditText mailto,mailSub,mailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        sendButton = findViewById(R.id.sendbutton);
        mailto = findViewById(R.id.mailto);
        mailSub = findViewById(R.id.mailsub);
        mailMessage = findViewById(R.id.message);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub = mailSub.getText().toString();
                String mes = mailMessage.getText().toString();
                if(mailSub.getText().toString().isEmpty()&& mailMessage.getText().toString().isEmpty()){
                    Toast.makeText(Email.this, "Please Fill in details to send", Toast.LENGTH_SHORT).show();
                }
                else if(mailSub.getText().toString().isEmpty()){
                    Toast.makeText(Email.this, "Enter a subject ", Toast.LENGTH_SHORT).show();
                    mailSub.requestFocus();
                }
                else if(mailMessage.getText().toString().isEmpty()){
                    Toast.makeText(Email.this, "Provide a Message body to send", Toast.LENGTH_SHORT).show();
                    mailMessage.requestFocus();
                }
                else {

                    Intent sendMessage = new Intent(Intent.ACTION_SEND);
                    sendMessage.putExtra(Intent.EXTRA_SUBJECT, sub);
                    sendMessage.putExtra(Intent.EXTRA_TEXT, mes);
                    sendMessage.setType("mes/rfc822");
                    startActivity(Intent.createChooser(sendMessage, "Send"));
                }
            }
        });
    }
}
