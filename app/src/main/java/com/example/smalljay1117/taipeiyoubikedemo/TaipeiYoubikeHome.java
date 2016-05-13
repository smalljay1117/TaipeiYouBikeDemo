package com.example.smalljay1117.taipeiyoubikedemo;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class TaipeiYoubikeHome extends AppCompatActivity {

    private Button mbtn_voice, mbtn_next;
    private String district;
    private String mJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taipei_youbike_home);

        mJson = getIntent().getStringExtra("json");
    }

    public void voice(View view) {
        // 語音辨識
        mbtn_voice = (Button) view;
        district = mbtn_voice.getText().toString();
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 語音辨識回呼確認
        if (resultCode == RESULT_OK) {
            ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String answer = text.get(0);
//            Toast.makeText(TaipeiYoubikeDistrict.this, answer + "", Toast.LENGTH_SHORT).show();
            goDistrict(answer);
        }
    }

    public void goDistrict(String data) {
        // 語音辨識結果
        Intent intent = new Intent(TaipeiYoubikeHome.this, TaipeiYoubikeStation.class);
        if (data.equals("中正區")) {
            intent.putExtra("station", "中正區");
        } else if (data.equals("大同區")) {
            intent.putExtra("station", "大同區");
        } else if (data.equals("中山區")) {
            intent.putExtra("station", "中山區");
        } else if (data.equals("松山區")) {
            intent.putExtra("station", "松山區");
        } else if (data.equals("大安區")) {
            intent.putExtra("station", "大安區");
        } else if (data.equals("萬華區")) {
            intent.putExtra("station", "萬華區");
        } else if (data.equals("信義區")) {
            intent.putExtra("station", "信義區");
        } else if (data.equals("士林區")) {
            intent.putExtra("station", "士林區");
        } else if (data.equals("北投區")) {
            intent.putExtra("station", "北投區");
        } else if (data.equals("內湖區")) {
            intent.putExtra("station", "內湖區");
        } else if (data.equals("南港區")) {
            intent.putExtra("station", "南港區");
        } else if (data.equals("文山區")) {
            intent.putExtra("station", "文山區");
        } else {
            Toast.makeText(TaipeiYoubikeHome.this, "無法辨識", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("json", mJson);
        startActivity(intent);
    }

    public void next(View view) {
        Intent intent = new Intent(TaipeiYoubikeHome.this, TaipeiYoubikeDistrict.class);
        intent.putExtra("json", mJson);
        startActivity(intent);
    }
}
