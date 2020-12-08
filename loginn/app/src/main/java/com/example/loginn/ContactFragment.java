package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactFragment extends Fragment {
    private EditText etC1;
    private EditText etC2;
    private EditText etC3;

    private EditText etCN1;
    private EditText etCN2;
    private EditText etCN3;

    private Button btnRetrive;
    private Button btnContact;
    private DatabaseReference mDatabaseReference, reference;
    //private FirebaseDatabase rootNode;
    ContactRoom contactRoom;
   private String userid;
   private String email;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getActivity().setContentView(R.layout.frag_contact);
//        etC1 = (EditText) getActivity().findViewById(R.id.etC1);
//        etC1 = (EditText) getActivity().findViewById(R.id.etC2);
//        etC1 = (EditText) getActivity().findViewById(R.id.etC3);
//
//        btnContact = (Button) getActivity().findViewById(R.id.btnContact);
//        tvContact = (TextView) getActivity().findViewById(R.id.tvContact);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        //return inflater.inflate(R.layout.frag_contact,container,false) ;
        View v= inflater.inflate(R.layout.frag_contact,container,false) ;
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        // Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
        userid=currentFirebaseUser.getUid();
        //email = etEmailR.getText().toString().trim();
        etC1 = v.findViewById(R.id.etC1);
        etC2 = v.findViewById(R.id.etC2);
        etC3 = v.findViewById(R.id.etC3);


        etCN1 = v.findViewById(R.id.etCN1);
        etCN2 = v.findViewById(R.id.etCN2);
        etCN3 = v.findViewById(R.id.etCN3);
    //contactRoom=new ContactRoom();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        //rootNode = FirebaseDatabase.getInstance();
        //reference = rootNode.getReference("ContactRoom");

        btnContact = v.findViewById(R.id.btnContact);
        btnRetrive = v.findViewById(R.id.btnRetrive);

        btnRetrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactDe.class);
                startActivity(intent);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent;
//                intent = new Intent(getActivity(),MainActivity.class);
//                startActivity(intent);

                ContactRoom contactRoom = new ContactRoom(etCN1.getText().toString(),etC1.getText().toString(), etCN2.getText().toString(),etC2.getText().toString(), etCN3.getText().toString(),etC3.getText().toString());
                mDatabaseReference.child("ContactRoom").setValue(contactRoom);
                Toast.makeText(getActivity(), "Contact Saved", Toast.LENGTH_SHORT).show();
                //reference.child(userid).push().setValue("contactRoom");


//
//                        toast. show();
               // Intent intent = new Intent(getActivity(), HomeFragment.class);
               // startActivity(intent);

//                        Toast toast=Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG);
//                        toast. show();
                //finish();
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
