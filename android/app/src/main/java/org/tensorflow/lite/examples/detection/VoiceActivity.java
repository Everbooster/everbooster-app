package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.*;

public class VoiceActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title"); //인식한 객체의 레이블을 받아오기

        MediaPlayer mediaPlayer;

        if (title.equals("plastic bottle")) {
            setContentView(R.layout.activity_detect_plasticbottle);
            System.out.println("Plastic Bottle Detected!");

            // 플라스틱 보틀 음성 재생
            mediaPlayer=MediaPlayer.create(this,R.raw.audio_1);
            mediaPlayer.start();

            //음성 재생 후 다시 DetectorActivity.java 로 전환 // 이부분에 문제있나 ... 안넘어감
            Intent returnIntent = new Intent(VoiceActivity.this, DetectorActivity.class);
            startActivity(returnIntent);
        }
        else if(title.equals("plastic")) {
            System.out.println("Plastic Detected!");
            /*아직 음성 샘플을 안만들어서.. 암튼 밑에도 쭉 위에처럼 하면 될거같음.*/

        }
        else if(title.equals("can")) {
            System.out.println("Can Detected!");

        }
        else if(title.equals("glass bottle")) {
            System.out.println("Glass Bottle Detected!");


        }
        else if(title.equals("plastic bag")) {
            System.out.println("Plastic Bag Detected!");


        }
        else if(title.equals("paper bag")) {
            System.out.println("Paper Bag Detected!");


        }
    }
}
