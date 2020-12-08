package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContactDe extends AppCompatActivity {
    private TextView C1;
    private TextView C2;
    private TextView C3;
    private TextView CN1;
    private TextView CN2;
    private TextView CN3;
    private String userid;
    private Button btnBack;
    private Button btnRefresh;
    private TextView tvConInfo;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_contactd);
        C1 = findViewById(R.id.C1);
        C2 = findViewById(R.id.C2);
        C3 = findViewById(R.id.C3);
        btnBack = findViewById(R.id.btnBack);

        CN1 = findViewById(R.id.CN1);
        CN2 = findViewById(R.id.CN2);
        CN3 = findViewById(R.id.CN3);

        tvConInfo = findViewById(R.id.tvConInfo);
        //contactRoom=new ContactRoom();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
       // Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
        userid=currentFirebaseUser.getUid();


        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        btnRefresh = findViewById(R.id.btnRefresh);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactDe.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        final String[] etC1db = {new String()};
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom").push().child("MN1cmhSw9idBQbtF2pU");
                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");

                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.exists()){
//
//                        }
                        String etCN1db = dataSnapshot.child("etCN1").getValue().toString();
                        String etCN2db = dataSnapshot.child("etCN2").getValue().toString();
                        String etCN3db = dataSnapshot.child("etCN3").getValue().toString();

                        etC1db[0] = dataSnapshot.child("etC1").getValue().toString();
                        String etC2db = dataSnapshot.child("etC2").getValue().toString();
                        String etC3db = dataSnapshot.child("etC3").getValue().toString();
                        CN1.setText(etCN1db);
                        CN2.setText(etCN2db);
                        CN3.setText(etCN3db);
                        C1.setText(etC1db[0]);
                        C2.setText(etC2db);
                        C3.setText(etC3db);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                   // String p1=C1.getText().toString();
                String p1= etC1db[0];

              //  Toast.makeText(ContactDe.this, p1, Toast.LENGTH_SHORT).show();
            }
        });





    }
}