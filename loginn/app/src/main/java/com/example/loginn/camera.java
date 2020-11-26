package com.example.loginn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.camerakit.CameraKitView;

public class camera extends AppCompatActivity {

  String currentPhotoPath,imageFileName;
    private ImageView mImageView;

    private Button mStartCamera;

    private String mTempPhotoPath;

    private Bitmap mResultsBitmap;

    private ImageButton mClear, mSave, mShare;
    Bitmap bm;
    android.hardware.Camera camera ;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        //mAppExcutor = new AppExecutor();

        mImageView = findViewById(R.id.mImageView);
        mClear = findViewById(R.id.mClear);
        mSave = findViewById(R.id.Save);
        mShare = findViewById(R.id.Share);
        mStartCamera = findViewById(R.id.startCamera);

//        mImageView.setVisibility(View.GONE);
//        mShare.setVisibility(View.GONE);
//        mSave.setVisibility(View.GONE);
//        mClear.setVisibility(View.GONE);

        // mStartCamera.setOnClickListener();
        //camera = camera.open();
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setImageResource(0);
                mStartCamera.setVisibility(View.VISIBLE);
                mSave.setVisibility(View.GONE);
                mShare.setVisibility(View.GONE);
                mClear.setVisibility(View.GONE);
                bm.recycle();
            }
        });
    }
//        mStartCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(i, 100);
//
//
//            }
//        });
//    }

//        @Override
//        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
//            super.onActivityResult(requestCode, resultCode, data);
//            if (resultCode == RESULT_OK && requestCode == 100) {
//                bm = (Bitmap) data.getExtras().get("data");
//                mImageView.setImageBitmap(bm);
//            }
//
//        }

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new
                Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//takePictureIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) !=
                null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this,"ERR",Toast.LENGTH_LONG).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.contentprovider", photoFile);
                //takePictureIntent.setDataAndType(photoURI,"image");
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode ==
                RESULT_OK) {
            final File imageFile = new
                    File(getExternalFilesDir("images"), "my_profile_picture.jpg");
            if (imageFile.exists()) {
                imageFile.delete();
            }
            Bitmap imageBitmap =
                    BitmapFactory.decodeFile(currentPhotoPath);
            ;
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(imageFile);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100,
                        out);
            } catch (final Exception e) {
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (final IOException e) {
                }
            }
            mImageView.setImageBitmap(imageBitmap);
            // textView.setText(imageFileName);
            //galleryAddPic();
        } else
            Toast.makeText(this, "ERRor", Toast.LENGTH_LONG).show();
    }



    public File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        );
        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }



}
//
//        @Override
//        protected void onStart() {
//            super.onStart();
//            cameraKitView.onStart();
//        }
//
//        @Override
//        protected void onResume() {
//            super.onResume();
//            cameraKitView.onResume();
//        }
//
//        @Override
//        protected void onPause() {
//            cameraKitView.onPause();
//            super.onPause();
//        }
//
//        @Override
//        protected void onStop() {
//            cameraKitView.onStop();
//            super.onStop();
//        }
//
//        @Override
//        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
//    }
