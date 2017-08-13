package com.example.android.exerciseapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static android.R.attr.bitmap;
import static android.provider.LiveFolders.INTENT;

public class ReceivePreferenceActivity extends AppCompatActivity {
        private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_preference);

        TextView prefMessage = (TextView) findViewById(R.id.tv_receivedPref);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();

        String action = intent.getAction();

        if(Intent.ACTION_SEND.equals(action)){
            Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bitmap);

        }

    }


}
