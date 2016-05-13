package com.example.smalljay1117.taipeiyoubikedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TaipeiYoubikeDistrict extends AppCompatActivity {

    private Button mbtn_100, mbtn_103, mbtn_104, mbtn_105, mbtn_106, mbtn_108,
            mbtn_110, mbtn_111, mbtn_112, mbtn_114, mbtn_115, mbtn_116, mbtn_voice;

    private String mJson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youbike_district);

        init();
        mJson = getIntent().getStringExtra("json");
    }

    private void init() {
        mbtn_100 = (Button) findViewById(R.id.btn_100);
        mbtn_103 = (Button) findViewById(R.id.btn_103);
        mbtn_104 = (Button) findViewById(R.id.btn_104);
        mbtn_105 = (Button) findViewById(R.id.btn_105);
        mbtn_106 = (Button) findViewById(R.id.btn_106);
        mbtn_108 = (Button) findViewById(R.id.btn_108);
        mbtn_110 = (Button) findViewById(R.id.btn_110);
        mbtn_111 = (Button) findViewById(R.id.btn_111);
        mbtn_112 = (Button) findViewById(R.id.btn_112);
        mbtn_114 = (Button) findViewById(R.id.btn_114);
        mbtn_115 = (Button) findViewById(R.id.btn_115);
        mbtn_116 = (Button) findViewById(R.id.btn_116);
    }

    public void onClick(View view) {
        Intent intent = new Intent(TaipeiYoubikeDistrict.this, TaipeiYoubikeStation.class);
        switch (view.getId()) {
            case R.id.btn_100:
                intent.putExtra("station", "中正區");
                break;
            case R.id.btn_103:
                intent.putExtra("station", "大同區");
                break;
            case R.id.btn_104:
                intent.putExtra("station", "中山區");
                break;
            case R.id.btn_105:
                intent.putExtra("station", "松山區");
                break;
            case R.id.btn_106:
                intent.putExtra("station", "大安區");
                break;
            case R.id.btn_108:
                intent.putExtra("station", "萬華區");
                break;
            case R.id.btn_110:
                intent.putExtra("station", "信義區");
                break;
            case R.id.btn_111:
                intent.putExtra("station", "士林區");
                break;
            case R.id.btn_112:
                intent.putExtra("station", "北投區");
                break;
            case R.id.btn_114:
                intent.putExtra("station", "內湖區");
                break;
            case R.id.btn_115:
                intent.putExtra("station", "南港區");
                break;
            case R.id.btn_116:
                intent.putExtra("station", "文山區");
                break;
        }
        intent.putExtra("json", mJson);
        startActivity(intent);
    }
}
