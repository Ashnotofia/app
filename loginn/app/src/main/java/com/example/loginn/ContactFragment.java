package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    private EditText etC1;
    private EditText etC2;
    private EditText etC3;

    private Button btnContact;


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


        etC1 = v.findViewById(R.id.etC1);
        etC1 = v.findViewById(R.id.etC2);
        etC1 = v.findViewById(R.id.etC3);




        btnContact = v.findViewById(R.id.btnContact);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getActivity(),MainActivity.class);
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
