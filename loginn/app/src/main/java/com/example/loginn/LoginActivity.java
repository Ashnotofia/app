package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    private EditText etEmail;
    private EditText etPass;

    private TextView tvWelcome;
    private TextView tvFP;

    private TextView tvNOT;
    private TextView tvSignUp;
    private TextView tvMsg;

    private Button btnLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvFP = (TextView) findViewById(R.id.tvFP);

        tvNOT = (TextView) findViewById(R.id.tvNOT);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);

        btnLogin = (Button) findViewById(R.id.btnLogin);


        tvMsg = (TextView) findViewById(R.id.tvMsg);

        tvMsg.setText("");

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tvSignUp:
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);

//                        Toast toast=Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG);
//                        toast. show();
                }

            }
        });
//        @Override
//        public void onStart() {
//            super.onStart();
//            // Check if user is signed in (non-null) and update UI accordingly.
//            FirebaseUser currentUser = mAuth.getCurrentUser();
//            updateUI(currentUser);
//        }

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            //startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            FirebaseUser currentUser = mAuth.getCurrentUser();
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
            finish();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString().trim();
                String pass = etPass.getText().toString().trim();
                loginUser(email, pass);
            }
        });}

    //
//                if(TextUtils.isEmpty(email)){
//                    etEmail.setError("Email is required");
//                    return;
//                }
//                if(TextUtils.isEmpty(pass)){
//                    etPass.setError("Password is required");
//                    return;
//                }
//    private void loginUser(String email, String pass) {
//
//        mAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(
//                new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
//                        finish();
//                    }
//                }
//        );
//    }
//}

    private void loginUser(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Login Failed.",Toast.LENGTH_LONG).show();
                            // updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });
    }
}

                //validate2(etUserName.getText().toString(),etPassword.getText().toString());
                //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                //startActivity(intent);

//                if (etEmail.getText().toString().equals("Ash") && etPass.getText().toString().equals("1234")) {
//                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                    startActivity(intent);
//
//                } else {
//                    // tvMsg.setText("Invalid Input");
//                    tvMsg.setText("");
//
//
//                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG);
//                    //toast. setMargin(50,50);
//                    toast.show();
//                }



