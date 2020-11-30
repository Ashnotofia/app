package com.example.loginn;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class EmailActivity extends AppCompatActivity {
    Button btnSendMessage;
    EditText etMessage, etMobileNumber;
    CountryCodePicker countryCodePicker;
    String strMessage, strMobileNumber = "", A;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        A="Help!! I'm in DANGER \n My current location is http://maps.google.com/?q=19.0410042,73.0168106";
        btnSendMessage = findViewById(R.id.btnSendMessage);
        etMessage = findViewById(R.id.etMessage);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        countryCodePicker = findViewById(R.id.countryCodePicker);
       // etMobileNumber.setText("7710849989");

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        //etMobileNumber.append("");
        //String adb = dataSnapshot.child("etCN1").getValue().toString();


        //etMessage.setText(adb);
                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");

                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.exists()){
//
//                        }
                        String adb = dataSnapshot.child("etC1").getValue().toString();


                        etMobileNumber.setText(adb);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



                btnSendMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");
                        strMessage = etMessage.getText().toString();
                        strMobileNumber = etMobileNumber.getText().toString();

                        if (etMobileNumber.getText().toString().isEmpty() && etMessage.getText().toString().isEmpty()) {
                            Toast.makeText(EmailActivity.this, " Enter Mobile Number and Message you want to send", Toast.LENGTH_SHORT).show();
                        } else {

                            countryCodePicker.registerCarrierNumberEditText(etMobileNumber);
                            strMobileNumber = countryCodePicker.getFullNumber();

                            boolean installed = appInstalledOrNot("com.whatsapp");
                            if (installed) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + strMobileNumber
                                        + "&text=" + strMessage + "\n" + A));
                                startActivity(intent);
                                etMobileNumber.setText("");
                                etMessage.setText("");// to clear edit text when you send message on whatsapp

                            } else {
                                Toast.makeText(EmailActivity.this, "WhatsApp not installed on your Device", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private boolean appInstalledOrNot(String uri){
        PackageManager packageManager = getPackageManager();
        boolean appInstalled;

        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            appInstalled = true;
        }catch (PackageManager.NameNotFoundException e){
            appInstalled = false;
        }
        return appInstalled;
    }
}