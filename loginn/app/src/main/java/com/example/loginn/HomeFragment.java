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

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {



    //String etC1db="9869750730";
    //String Mdb="aaya kya msg!!";
    String Mdb;
    String pp,pp1,pp2;
    private Context globalContext = null;

    private TextView tvM;
    private SmsManager sm;
    private ImageView ph_sos;

    private ImageView ph_alarm;
    private ImageView ph_fakecall;
    private ImageView ph_camera;
    private ImageView ph_mail;
    android.hardware.Camera camera ;
    private TextView Cs1,Cs2,Cs3;
    private GoogleMap mMap;
    private LatLng latLng;
    private DatabaseReference mDatabaseReference;

    private DatabaseReference cDatabaseReference;
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
        sm=SmsManager.getDefault();
        //return inflater.inflate(R.layout.frag_contact,container,false) ;
        View v= inflater.inflate(R.layout.frag_home,container,false) ;
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        cDatabaseReference = FirebaseDatabase.getInstance().getReference();


//        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
//        Toast.makeText(getActivity(), "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();

        globalContext = this.getActivity();

        ph_alarm = v.findViewById(R.id.ph_alarm);
        ph_sos = v.findViewById(R.id.ph_sos);
        ph_fakecall = v.findViewById(R.id.ph_fakecall);
        ph_camera = v.findViewById(R.id.ph_camera);
        ph_mail = v.findViewById(R.id.ph_mail);
        //tvM = v.findViewById(R.id.tv4);
        Cs1 = v.findViewById(R.id.Cs1);
        //Cs2 = v.findViewById(R.id.Cs2);
        Cs3 = v.findViewById(R.id.C2);

        Cs2 = v.findViewById(R.id.Cs2);
        //tvM= v.findViewById(R.id.C1);
        //String mmmm="aaa";
        //Cs1 = v.findViewById(R.id.C1);

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
//        GPSTracker mGPS = new GPSTracker(getActivity());
//
//
//        if(mGPS.canGetLocation ){
//            mGPS.getLocation();
        //latLng = new LatLng(location.getLatitude(),location.getLongitude());
          //  tv4.setText(  mMap.getLatitude() + "," + mMap.getLongitude());
//
//        }else{
//            tv4.setText("Unabletofind");
////            System.out.println("Unable");
//        }
//
//        sm= SmsManager.getDefault();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("MapLoc");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Mdb = dataSnapshot.child("LOC").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
        cDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");

        //cDatabaseReference = FirebaseDatabase.getInstance().getReference();

        cDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 pp = dataSnapshot.child("etC1").getValue().toString();
                 pp1 = dataSnapshot.child("etC2").getValue().toString();
                 pp2 = dataSnapshot.child("etC3").getValue().toString();
                // uu[0] = dataSnapshot.child("etC1").getValue().toString();
//                        String etC2db = dataSnapshot.child("etC2").getValue().toString();
//                        String etC3db = dataSnapshot.child("etC3").getValue().toString();
//                        list.clear();
//                        list.add(dataSnapshot.child("etC1").getValue().toString());
//                        Intent intent = new Intent(getActivity(),ContactRoom.class);
//                        intent.putExtra("pp",uu[0]);
//                        startActivity(intent);
                //    Cs1.setText(uu[0]);
//                        Cs2.setText(etC2db);
//                        Cs3.setText(etC3db);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
//
        });


        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.policesiren);

        ph_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
//alarm og
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

            //try
//            public void onClick(View v) {
//                cDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");
//                cDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String etC1db = dataSnapshot.child("etC1").getValue().toString();
//                        String etC2db = dataSnapshot.child("etC2").getValue().toString();
//                        String etC3db = dataSnapshot.child("etC3").getValue().toString();
//
//                        Cs1.setText(etC1db);
//                        Cs2.setText(etC2db);
//                        Cs3.setText(etC3db);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("MapLoc");
//
//
//                mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                        if(dataSnapshot.exists()){
////
////                        }
//                        // String etC3db = dataSnapshot.child("etC3").getValue().toString();
//
//
//                        String Mdb = dataSnapshot.child("LOC").getValue().toString();
//                        tvM.setText(Mdb);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//

//                sm.sendTextMessage(Cs1.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);
//                sm.sendTextMessage(Cs2.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);
//                sm.sendTextMessage(Cs3.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);

                //Toast.makeText(this,"message sent",Toast.LENGTH_LONG).show();

                //Toast.makeText(getActivity(), "SOS sent", Toast.LENGTH_SHORT).show();
//                Intent intent;
//                intent = new Intent(getActivity(),MapsActivity.class);
//                startActivity(intent);

            //}


          });
        ph_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EmailActivity.class);
                startActivity(intent);
            }
        });
//ph_mail.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), Contactd.class);
//        startActivity(intent);
//    }
//});

        ph_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");
//                cDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String etC1db = dataSnapshot.child("etC1").getValue().toString();
//                        String etC2db = dataSnapshot.child("etC2").getValue().toString();
//                        String etC3db = dataSnapshot.child("etC3").getValue().toString();
//
//                        Cs1.setText(etC1db);
//                        Cs2.setText(etC2db);
//                        Cs3.setText(etC3db);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("MapLoc");
//
//
//                mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                        if(dataSnapshot.exists()){
////
////                        }
//                       // String etC3db = dataSnapshot.child("etC3").getValue().toString();
//
//
//                        String Mdb = dataSnapshot.child("LOC").getValue().toString();
//                        tvM.setText(Mdb);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
////
////
//                sm.sendTextMessage(Cs1.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);
//                sm.sendTextMessage(Cs2.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);
//                sm.sendTextMessage(Cs3.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tvM.getText().toString(),null,null);
//
//                //Toast.makeText(this,"message sent",Toast.LENGTH_LONG).show();
//
//                //Toast.makeText(getActivity(), "SOS sent", Toast.LENGTH_SHORT).show();


                Intent intent;
                intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);

                sendSMSMessage();

            }
        });

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

      //  sendSMSMessage();
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
//    String etC2db;
//    String etC3db;
    //DatabaseReference = FirebaseDatabase.getInstance().getReference().child("ContactRoom");

    //final ArrayList<String> list= new ArrayList<>();
    //final ArrayAdapter adapter =new ArrayAdapter<String>(this,R.layout.list_item,list);
    //listView.setAdapter(adapter);
    final String[] uu = {new String()};


    protected void sendSMSMessage() {
//



//String mm= tvM.getText().toString();
//String pp= uu[0];

// String pp=Cs1.getText().toString();
        //mmm = mm.getText().toString();

        SmsManager manager = SmsManager.getDefault();

        manager.sendTextMessage(pp,null,"I'm in Danger...\nMy current location is http://maps.google.com/?q="+Mdb,null,null);
        manager.sendTextMessage(pp1,null,"I'm in Danger...\nMy current location is http://maps.google.com/?q="+Mdb,null,null);
        manager.sendTextMessage(pp2,null,"I'm in Danger...\nMy current location is http://maps.google.com/?q="+Mdb,null,null);

        Toast.makeText(getActivity(),"Sent SOS",Toast.LENGTH_LONG).show();

        // Toast.makeText(getActivity(),""+pp+" "+Mdb,Toast.LENGTH_LONG).show();

    }

}
