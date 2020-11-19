package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvWelcomeR;
    private EditText etEmailR;

    private EditText etFNameR;
    private EditText etUserNameR;

    private EditText etDOBR;

    private EditText etPhoneR;

    private EditText etPassR;
    private EditText etPassReR;

    private TextView tvAlreadyR;

    private Button btnRegister;

    private TextView tvOR;
    private Button btnFB;
    private Button btnGoogle;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
//        if(mAuth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(),HomeFragment.class));
//            finish();
//        }

        tvWelcomeR = (TextView) findViewById(R.id.tvWelcomeR);
        etEmailR = (EditText) findViewById(R.id.etEmailR);
        etPassR = (EditText) findViewById(R.id.etPassR);
        etPassReR = (EditText) findViewById(R.id.etPassReR);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        etFNameR = (EditText) findViewById(R.id.etFNameR);
        etUserNameR = (EditText) findViewById(R.id.etUserNameR);
        etPhoneR = (EditText) findViewById(R.id.etPhoneR);
        etDOBR = (EditText) findViewById(R.id.etDOBR);

        tvAlreadyR = (TextView) findViewById(R.id.tvAlreadyR);

        tvOR = (TextView) findViewById(R.id.tvOR);
        btnFB = (Button) findViewById(R.id.btnFB);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        tvAlreadyR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tvAlreadyR:
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);

//                        Toast toast=Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG);
//                        toast. show();
                }

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Toast toast=Toast.makeText(getApplicationContext(),"Register Working",Toast.LENGTH_LONG);
                //  toast. show();


//                String name = etFNameR.getText().toString().trim();
//                String username = etUserNameR.getText().toString().trim();
//
//                String dob = etDOBR.getText().toString().trim();
//                String phone = etPhoneR.getText().toString().trim();
                String email = etEmailR.getText().toString().trim();
                String pass = etPassR.getText().toString().trim();
//                String repass = etPassReR.getText().toString().trim();
//
                if (TextUtils.isEmpty(email)) {
                    etEmailR.setError("Email is required");
                     return;
                }
                if (TextUtils.isEmpty(pass)) {
                    etPassR.setError("Password is required");
                    return;
                }
                if (pass.length() < 6) {
                    etPassR.setError("Password must be atleast 6 characters");
                     return;
                } else {
                    registerUser(email, pass);
                }
            }

        });

    }

    private void registerUser(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(
                RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"Register Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}

//                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//
//                                    Toast toast=Toast.makeText(getApplicationContext(),"User Successfully Registered",Toast.LENGTH_LONG);
//                                    toast. show();
//
//                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
////
////                                    Log.d(TAG, "createUserWithEmail:success");
////                                    FirebaseUser user = mAuth.getCurrentUser();
////                                    updateUI(user);
//                                } else {
//                                    Toast toast = Toast.makeText(getApplicationContext(), "Registration Failed" + task.getException().getMessage(), Toast.LENGTH_LONG);
//                                    toast.show();
//                                    // If sign in fails, display a message to the user.
//                                    // Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                    // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    //        Toast.LENGTH_SHORT).show();
//                                }
//
//                                // ...
//                            }
//                        });






