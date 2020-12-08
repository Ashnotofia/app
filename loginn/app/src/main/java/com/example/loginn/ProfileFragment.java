package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileFragment extends Fragment {



    //private TextView tvProfileDemo;
    private EditText proUsername;
    private EditText proName;
    private EditText proMyphone;
    private EditText proDOB;
    private EditText proGName;
    private EditText proGphone;
    private EditText proAge;
    private EditText proEmail;
    private EditText proAddress;

    private ImageView proImage;
    private Button btnProSave;
    private Button btnProDetail;
    private DatabaseReference mDatabaseReference;
    //private FirebaseDatabase rootNode;
    ProfileRoom profileRoom;
    //private String userid;
    //private String email;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        //return inflater.inflate(R.layout.frag_contact,container,false) ;
        View v= inflater.inflate(R.layout.frag_profile,container,false) ;

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        // Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
        //userid=currentFirebaseUser.getUid();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        btnProSave = v.findViewById(R.id.btnProSave);
        proImage= v.findViewById(R.id.proImage);
        proAddress = v.findViewById(R.id.proAddress);

       // proUsername= v.findViewById(R.id.proUsername);
        proName = v.findViewById(R.id.proName);

        proGName= v.findViewById(R.id.proGName);
        proMyphone = v.findViewById(R.id.proMyphone);
        proGphone= v.findViewById(R.id.proGphone);
        proDOB = v.findViewById(R.id.proDOB);
        proEmail= v.findViewById(R.id.proEmail);
        proAge = v.findViewById(R.id.pro_Age);


        //  tvProfileDemo = v.findViewById(R.id.tvProfileDemo);
        btnProDetail = v.findViewById(R.id.btnProDetail);



        btnProSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast toast=Toast.makeText(getContext(),"Profile Page Working",Toast.LENGTH_LONG);
//                toast. show();
                ProfileRoom profileRoom = new ProfileRoom(proName.getText().toString(),proMyphone.getText().toString(), proGName.getText().toString(),proGphone.getText().toString(), proDOB.getText().toString(),proAge.getText().toString(),proEmail.getText().toString(),proAddress.getText().toString());
                mDatabaseReference.child("ProfileRoom").setValue(profileRoom);
                Toast.makeText(getActivity(), "Profile Data Saved", Toast.LENGTH_SHORT).show();

            }
        });


        btnProDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ProfileDe.class);
                startActivity(intent);
            }
        });

        return v;
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
}
