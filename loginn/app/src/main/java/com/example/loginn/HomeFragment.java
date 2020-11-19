package com.example.loginn;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Context globalContext = null;



    private ImageView ph_sos;

    private ImageView ph_alarm;
    private ImageView ph_fakecall;
    private ImageView ph_camera;
    private ImageView ph_mail;



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
        View v= inflater.inflate(R.layout.frag_home,container,false) ;



        globalContext = this.getActivity();

        ph_alarm = v.findViewById(R.id.ph_alarm);
        ph_sos = v.findViewById(R.id.ph_sos);
        ph_fakecall = v.findViewById(R.id.ph_fakecall);
        ph_camera = v.findViewById(R.id.ph_camera);
        ph_mail = v.findViewById(R.id.ph_mail);


        View alertLayout = inflater.inflate(R.layout.popup_layout, null);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();

        // Setting Dialog Title
        alertDialog.setTitle("Instructions");

        // Setting Dialog Message
        alertDialog.setView(alertLayout);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.instruct_icon);



        // Showing Alert Message
        alertDialog.show();


//        ph_alarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MyBroadcastReceiver.class);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getApplicationContext(), 232, intent, 0);
//                AlarmManager alarmManager = (AlarmManager) getActivity().getApplicationContext().getSystemService(ALARM_SERVICE);
//                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5000), pendingIntent);
//                Toast.makeText(getActivity().getApplicationContext(), "Alarm will start with in five seconds", Toast.LENGTH_SHORT).show();
//
//            }
//        });



//                public void Play(View view) {
//                    if(isPlaing) {
//                        mediaPlayer.start();
//                        buttonPlay.setText("Pause");
//                        isPlaing = false;
//                    }else {
//                        mediaPlayer.pause();
//                        buttonPlay.setText("Play");
//                        isPlaing = true;
//                    }
//                }
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.policesiren);

        ph_alarm.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
               // int flagOn=0;
               // boolean flag = true;
                if(!sound.isPlaying()) {
                    //sound.setLooping(true);
                    Toast.makeText(getActivity(), "Alarm's on...", Toast.LENGTH_SHORT).show();
                    sound.start();
                }
                else{
                    Toast.makeText(getActivity(), "Alarm's off...", Toast.LENGTH_SHORT).show();
                    sound.pause();
                }

            }
          });



ph_camera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), LoginActivity.class);
//        startActivity(intent);
        Toast.makeText(getActivity(), "Alarm will start with in five seconds", Toast.LENGTH_SHORT).show();
    }
});

ph_fakecall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), RecievedCall.class);
        startActivity(intent);
    }
});


//        btnContact = v.findViewById(R.id.btnContact);
//        btnContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent;
//                intent = new Intent(getActivity(),MainActivity.class);
//                startActivity(intent);
//            }
//        });

        return v;
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
}
