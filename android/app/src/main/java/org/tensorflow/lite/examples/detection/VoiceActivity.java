package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.*;

public class VoiceActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title"); //인식한 객체의 레이블을 받아오기

        MediaPlayer mediaPlayer;
        setContentView(R.layout.activity_guide);

        Intent newintent = new Intent(VoiceActivity.this, DetectorActivity.class);
        intent.putExtra("title", title); //인식한 객체의 라벨을 VoiceActivity 로 전달


        if (title.equals("plastic bottle")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_1_pb);
            mediaPlayer.start();

        } else if (title.equals("plastic")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_5_plastic);
            mediaPlayer.start();

        } else if (title.equals("can")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_4_can);
            mediaPlayer.start();

        } else if (title.equals("glass bottle")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_2_glass);
            mediaPlayer.start();

        } else if (title.equals("plastic bag")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_6_pb);
            mediaPlayer.start();

        } else if (title.equals("paper bag")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_3_paper);
            mediaPlayer.start();
        }

        //해당 객체에 대한 음성 안내가 끝나면 restart 안내 보이스 출력
        mediaPlayer=MediaPlayer.create(this,R.raw.audio_7_restart);
        mediaPlayer.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("Splash Activity", "Application is Running");
                startActivity(newintent);
                finish();
            }
        }, 20000);
    }
}
