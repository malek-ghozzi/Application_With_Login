package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView user,info;
    private TextView pssd;
    private Button login;
    private int counter=6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editTextname);
        password = (EditText) findViewById(R.id.editTextpassword);
        user = (TextView) findViewById(R.id.userid);
        pssd = (TextView) findViewById(R.id.pssd);
        info=(TextView)findViewById(R.id.attempts) ;
        login = (Button) findViewById(R.id.btn);
        info.setText("Nombre of attempts remaining:5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
        private void validate(String username,String userpssd){
            if((username.equals("user"))&&(userpssd.equals("123"))) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }else{
                counter--;
                info.setText("Nombre of attempts remaining:"+ String.valueOf(counter));
                if(counter == 0){login.setEnabled(false);



            }

            }
        }
    }
