package com.dkl.auser.myapplication1031;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.Manifest;
import static android.Manifest.permission.*;
import android.support.v4.app.ActivityCompat;
import static android.Manifest.permission.*;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private VideoView vV;
    private MediaController mc;
    private Uri uri;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vV = (VideoView)findViewById(R.id.videoView);
        mc = new MediaController(this);
        if(mc == null){

            vV.setMediaController(mc);
        }
        uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"/storage/sdcard/Download/black_hole.mp4");
//        "/Movies/sawing_a_baby_in_half.mp4"black_hole
        vV.setVideoURI(uri);
        vV.setOnPreparedListener(onPreparedListener);
    }


    MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (position == 0) {
                vV.start();
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mc.setAnchorView(vV);
                    }
                });
            }
        }
        };






//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case 10: {
////                MY_PERMISSIONS_REQUEST_READ_CONTACTS
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    // permission was granted, yay! Do the
//                    // contacts-related task you need to do.
//
//                } else {
//
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request
//        }
//    }


//    // Here, thisActivity is the current activity
//if (ContextCompat.checkSelfPermission(thisActivity,
//    Manifest.permission.READ_CONTACTS)
//            != PackageManager.PERMISSION_GRANTED) {
//
//        // Should we show an explanation?
//        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                Manifest.permission.READ_CONTACTS)) {
//
//            // Show an explanation to the user *asynchronously* -- don't block
//            // this thread waiting for the user's response! After the user
//            // sees the explanation, try again to request the permission.
//
//        } else {
//
//            // No explanation needed, we can request the permission.
//
//            ActivityCompat.requestPermissions(MainActivity.this,
//                    new String[]{AndroidManifest.permission.READ_CONTACTS},
//                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//
//            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//            // app-defined int constant. The callback method gets the
//            // result of the request.
//        }
//    }
}
//    private class onPreparedListener {



