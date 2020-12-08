package com.example.loginn;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;

//import com.camerakit.CameraKitView;

public class camera extends AppCompatActivity {

    String currentPhotoPath, imageFileName;
    private ImageView mImageView;

    private Button mStartCamera;

    private String mTempPhotoPath;

    private Bitmap mResultsBitmap;

    private ImageButton mClear, mSave, mShare;
    Bitmap bm;
    android.hardware.Camera camera;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        //mAppExcutor = new AppExecutor();
        ActivityCompat.requestPermissions(camera.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        ActivityCompat.requestPermissions(camera.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

        mImageView = findViewById(R.id.mImageView);
        mClear = findViewById(R.id.mClear);
        mSave = findViewById(R.id.Save);
        mShare = findViewById(R.id.Share);
        mStartCamera = findViewById(R.id.startCamera);


        if (ContextCompat.checkSelfPermission(camera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(camera.this, new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }
        mStartCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent (Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent,0);
//
//
//            }
            public void onClick(View view) {
                saveToGallery();
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                //Intent intent = new Intent(Location.this,MessageActivity.class);
                Intent intent = new Intent(camera.this,HomeActivity.class);
                startActivity(intent);
            }
        });
//
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(captureImage);
        }

//        else if ( resultCode == 0) {
//            final File imageFile = new
//                    File(getExternalFilesDir("SIDEKICK"), "my_profile_picture.jpg");
//            if (imageFile.exists()) {
//                imageFile.delete();
//            }
//            Bitmap imageBitmap =
//                    BitmapFactory.decodeFile(currentPhotoPath);
//
//            FileOutputStream out = null;
//            try {
//                out = new FileOutputStream(imageFile);
//                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100,
//                        out);
//            } catch (final Exception e) {
//            } finally {
//                try {
//                    if (out != null) {
//                        out.close();
//                    }
//                } catch (final IOException e) {
//                }
//            }
//            Toast.makeText(this, "Image Saved", Toast.LENGTH_LONG).show();
//            //mImageView.setImageBitmap(imageBitmap);
//            // textView.setText(imageFileName);
//            //galleryAddPic();
//        } else
//            Toast.makeText(this, "ERRor", Toast.LENGTH_LONG).show();


    }


//    public File createImageFile() throws IOException {
//        // Create an image file name
//        String timeStamp = new
//                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir =
//                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName, /* prefix */
//                ".jpg", /* suffix */
//                storageDir /* directory */
//        );
//        // Save a file: path for use with ACTION_VIEW intents
//        currentPhotoPath = image.getAbsolutePath();
//        return image;
    //  }

    private void saveToGallery(){
        Toast.makeText(this, "Image Saved", Toast.LENGTH_LONG).show();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) mImageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getAbsolutePath() + "/MyPics");
        dir.mkdirs();

        String filename = String.format("%d.png",System.currentTimeMillis());
        File outFile = new File(dir,filename);
        try{
            outputStream = new FileOutputStream(outFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try{
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}