package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        //return inflater.inflate(R.layout.frag_contact,container,false) ;
        View v= inflater.inflate(R.layout.frag_profile,container,false) ;

        btnProSave = v.findViewById(R.id.btnProSave);
        proImage= v.findViewById(R.id.proImage);
        proAddress = v.findViewById(R.id.proAddress);

        proUsername= v.findViewById(R.id.proUsername);
        proName = v.findViewById(R.id.proName);

        proGName= v.findViewById(R.id.proGName);
        proMyphone = v.findViewById(R.id.proMyphone);
        proGphone= v.findViewById(R.id.proGphone);
        proDOB = v.findViewById(R.id.proDOB);
        proEmail= v.findViewById(R.id.proEmail);
        proAge = v.findViewById(R.id.pro_Age);


        //  tvProfileDemo = v.findViewById(R.id.tvProfileDemo);


        btnProSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast=Toast.makeText(getContext(),"Profile Page Working",Toast.LENGTH_LONG);
                toast. show();
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
