package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.*;

public class VoiceActivity extends AppCompatActivity {

    public static final int DURATION_TIME_PLASTIC_BOTTLE = 15500;
    public static final int DURATION_TIME_PLASTIC = 13500;
    public static final int DURATION_TIME_CAN = 18300;
    public static final int DURATION_TIME_GLASS_BOTTLE = 20300;
    public static final int DURATION_TIME_PLASTIC_BAG = 14300;
    public static final int DURATION_TIME_PAPER_PACK = 16000;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Handler handler = new Handler();
        String title = intent.getStringExtra("title"); //인식한 객체의 레이블을 받아오기

        MediaPlayer mediaPlayer;
        setContentView(R.layout.activity_guide);

        Intent newintent = new Intent(VoiceActivity.this, DetectorActivity.class);
        intent.putExtra("title", title); //인식한 객체의 라벨을 VoiceActivity 로 전달


        if (title.equals("plastic bottle")) {
            voiceGuidance(R.raw.audio_1_pb);
            TimerSetting(DURATION_TIME_PLASTIC_BOTTLE,handler,newintent);

        } else if (title.equals("plastic")) {
            voiceGuidance(R.raw.audio_5_plastic);
            TimerSetting(DURATION_TIME_PLASTIC,handler,newintent);

        } else if (title.equals("can")) {
            voiceGuidance(R.raw.audio_4_can);
            TimerSetting(DURATION_TIME_CAN,handler,newintent);

        } else if (title.equals("glass bottle")) {
            voiceGuidance(R.raw.audio_2_glass);
            TimerSetting(DURATION_TIME_GLASS_BOTTLE,handler,newintent);

        } else if (title.equals("plastic bag")) {
            voiceGuidance(R.raw.audio_6_pb);
            TimerSetting(DURATION_TIME_PLASTIC_BAG,handler,newintent);

        } else if (title.equals("paper pack")) {
            voiceGuidance(R.raw.audio_3_paper);
            TimerSetting(DURATION_TIME_PAPER_PACK,handler,newintent);
        }
    }

    private void voiceGuidance(int mediaUid){
        MediaPlayer mediaPlayer;
        //해당 객체에 대한 음성 안내가 끝나면 restart 안내 보이스 출력
        mediaPlayer=MediaPlayer.create(this,mediaUid);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                performOnEnd();
            }
        });
        mediaPlayer.start();
    }

    private void performOnEnd(){
        MediaPlayer mp;
        //해당 객체에 대한 음성 안내가 끝나면 restart 안내 보이스 출력
        mp=MediaPlayer.create(this,R.raw.audio_7_restart);
        mp.start();
    }
    private void TimerSetting(int time, Handler handler, Intent nextintent){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("Splash Activity", "Application is Running");
                nextintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(nextintent);
                finish();
            }
        }, time);
    }
}
