package com.example.loginn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private EditText etUserName;
//    private EditText etPassword;
//    private Button btnLogin;
//    private TextView tvMsg;

    //splash
 //private static int SPLASH_TIME_OUT = 1000;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this,SplashActivity.class);
        startActivity(intent);


//        //splash
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(MainActivity.this, SplashActivity.class);
//                startActivity(homeIntent);
//                finish();
//
//            }
//        }, SPLASH_TIME_OUT);

//        etUserName = (EditText) findViewById(R.id.etUserName);
//        etPassword = (EditText) findViewById(R.id.etPassword);
//        btnLogin = (Button) findViewById(R.id.btnLogin);
//        tvMsg = (TextView)findViewById(R.id.tvMsg);
//
//        tvMsg.setText("");
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //validate2(etUserName.getText().toString(),etPassword.getText().toString());
//                    //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//                    //startActivity(intent);
//
//               if(etUserName.getText().toString().equals("Ash") && etPassword.getText().toString().equals("1234"))
//               {
//                   Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//                   startActivity(intent);
//
//               } else{
//                   tvMsg.setText("Invalid Input");
//
//                   Toast toast=Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_LONG);
//                   //toast. setMargin(50,50);
//                   toast. show();
//               }
//
//            }
//        });
    }
}