package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileDe extends AppCompatActivity {
    private TextView pname;
    private TextView pmobile;
    private TextView pg;
    private TextView pgn;
    private TextView pemail;
    private TextView paddr;
    private TextView pdob;
    private TextView page;
    private Button btnBack;
    private Button btnRefresh;
    private TextView tvProInfo;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_de);

        pname = findViewById(R.id.pname);
        paddr = findViewById(R.id.paddr);
        page= findViewById(R.id.page);

        btnBack = findViewById(R.id.btnBack);
        btnRefresh = findViewById(R.id.btnRefresh);

        tvProInfo = findViewById(R.id.tvProInfo);


        pg = findViewById(R.id.pg);
        pgn = findViewById(R.id.pgn);
        pdob = findViewById(R.id.pdob);
        pmobile = findViewById(R.id.pmobile);
        pemail = findViewById(R.id.pemail);
        //contactRoom=new ContactRoom();
        //FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        // Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
       // userid=currentFirebaseUser.getUid();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileDe.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom").push().child("MN1cmhSw9idBQbtF2pU");
                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ProfileRoom");

                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.exists()){
//
//                        }
                        String proNamedb = dataSnapshot.child("proName").getValue().toString();
                        String proMyphonedb = dataSnapshot.child("proMyphone").getValue().toString();
                        String proGNamedb = dataSnapshot.child("proGName").getValue().toString();

                        String proGphonedb = dataSnapshot.child("proGphone").getValue().toString();
                        String proDOBdb = dataSnapshot.child("proDOB").getValue().toString();
                        String proAgedb = dataSnapshot.child("proAge").getValue().toString();
                        String proEmaildb = dataSnapshot.child("proEmail").getValue().toString();
                        String proAddressdb = dataSnapshot.child("proAddress").getValue().toString();

                        pname.setText(proNamedb);
                        pmobile.setText(proMyphonedb);
                        pg.setText(proGNamedb);
                        pgn.setText(proGphonedb);
                        pdob.setText(proDOBdb);
                        page.setText(proAgedb);
                        pemail.setText(proEmaildb);
                        paddr.setText(proAddressdb);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}