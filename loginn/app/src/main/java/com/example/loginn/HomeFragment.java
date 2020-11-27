package com.example.loginn;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;

public class HomeFragment extends Fragment {

    private Context globalContext = null;
    private DatabaseReference mDatabaseReference;
private TextView tv4;
    private SmsManager sm;
    private ImageView ph_sos;

    private ImageView ph_alarm;
    private ImageView ph_fakecall;
    private ImageView ph_camera;
    private ImageView ph_mail;
    android.hardware.Camera camera ;
    private TextView Cs1,Cs2,Cs3;

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


//        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
//        Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();

        globalContext = this.getActivity();

        ph_alarm = v.findViewById(R.id.ph_alarm);
        ph_sos = v.findViewById(R.id.ph_sos);
        ph_fakecall = v.findViewById(R.id.ph_fakecall);
        ph_camera = v.findViewById(R.id.ph_camera);
        ph_mail = v.findViewById(R.id.ph_mail);
        tv4 = v.findViewById(R.id.tv4);
        Cs1 = v.findViewById(R.id.Cs1);
        Cs2 = v.findViewById(R.id.Cs2);
        Cs3 = v.findViewById(R.id.Cs3);


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
        GPSTracker mGPS = new GPSTracker(getActivity());


        if(mGPS.canGetLocation ){
            mGPS.getLocation();
            tv4.setText(  mGPS.getLatitude() + "," + mGPS.getLongitude());

        }else{
            tv4.setText("Unabletofind");
//            System.out.println("Unable");
        }

        sm= SmsManager.getDefault();


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

//ph_mail.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), Contactd.class);
//        startActivity(intent);
//    }
//});

ph_camera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), LoginActivity.class);
//        startActivity(intent);
       // Toast.makeText(getActivity(), "Alarm will start with in five seconds", Toast.LENGTH_SHORT).show();
//
        //Intent intent = new Intent(getActivity(), camera.class);
        Intent intent = new Intent(getActivity(), camera.class);
        startActivity(intent);



//        public static Camera getCameraInstance(){
//            Camera c = null;
//            try {
//                c = Camera.open(); // attempt to get a Camera instance
//            }
//            catch (Exception e){
//                // Camera is not available (in use or does not exist)
//            }
//            return c; // returns null if camera is unavailable
//        }
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

//        ph_sos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Toast.makeText(getActivity(),"sos working",Toast.LENGTH_LONG).show();
//                //sm= SmsManager.getDefault();
//                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");
//                mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                        if(dataSnapshot.exists()){
////
////                        }
//                      //  sm= SmsManager.getDefault();
//                        String etC1db = dataSnapshot.child("etC1").getValue().toString();
//                        String etC2db = dataSnapshot.child("etC2").getValue().toString();
//                        String etC3db = dataSnapshot.child("etC3").getValue().toString();
//
//
//                        Cs1.setText(etC1db);
//                        Cs2.setText(etC2db);
//                        Cs3.setText(etC3db);
//
//                        sm.sendTextMessage(Cs1.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//                        sm.sendTextMessage(Cs2.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//                        sm.sendTextMessage(Cs3.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//
//                        Toast.makeText(getActivity(),"message sent",Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//        });




        return v;
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }


//    public void send(View view){
//
//        sm.sendTextMessage(Cs1.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//        sm.sendTextMessage(Cs2.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//        sm.sendTextMessage(Cs3.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv4.getText().toString(),null,null);
//
//        Toast.makeText(getActivity(),"message sent",Toast.LENGTH_LONG).show();
//
//    }

}
