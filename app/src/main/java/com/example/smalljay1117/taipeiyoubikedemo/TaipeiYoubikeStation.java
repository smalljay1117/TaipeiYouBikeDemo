package com.example.smalljay1117.taipeiyoubikedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smalljay1117.taipeiyoubikedemo.data.TaipeiYoubikeData;
import com.example.smalljay1117.taipeiyoubikedemo.util.JSONUtility;

import org.json.JSONObject;

import java.util.ArrayList;

public class TaipeiYoubikeStation extends AppCompatActivity {

    private ListView mListView;
    private TaipeiYoubikeAdapter mYoubikeAdapter;
    private ArrayList<String> keyList;
    private ArrayList<TaipeiYoubikeData> mYoubikeDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youbike_station);

        mListView = (ListView) findViewById(R.id.listview);
        keyList = new ArrayList<>();
        mYoubikeDataList = new ArrayList<>();

        // 辨識gz檔內json格式的每一筆編號，如:0001
        for (int i = 1; i <= 255; i++) {
            String count = "";
            if (i < 10) {
                count = "000";
            } else if (i < 100) {
                count = "00";
            } else {
                count = "0";
            }

            keyList.add(count + i);
        }

        JSONObject jsonObject = JSONUtility.getJSONObject(getIntent().getStringExtra("json"));
        String station = getIntent().getStringExtra("station");
        setTitle(station);

        for (int i = 0; i < keyList.size(); i++) {
            if (JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "sarea").equals(station)) {
                TaipeiYoubikeData taipeiYoubikeData = new TaipeiYoubikeData();
                taipeiYoubikeData.sna = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "sna");
                taipeiYoubikeData.tot = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "tot");
                taipeiYoubikeData.sbi = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "sbi");
                taipeiYoubikeData.lat = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "lat");
                taipeiYoubikeData.lng = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "lng");
                taipeiYoubikeData.ar = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "ar");
                taipeiYoubikeData.bemp = JSONUtility.getStringFromJSONObject(JSONUtility.getJSONObject(jsonObject, keyList.get(i)), "bemp");
                mYoubikeDataList.add(taipeiYoubikeData);
            }
        }

        mYoubikeAdapter = new TaipeiYoubikeAdapter(TaipeiYoubikeStation.this, mYoubikeDataList);
        mListView.setAdapter(mYoubikeAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TaipeiYoubikeStation.this, TaipeiYoubikeMap.class);
                Bundle bundle = new Bundle();
                bundle.putString("sna", mYoubikeDataList.get(position).sna);
                bundle.putString("tot", mYoubikeDataList.get(position).tot);
                bundle.putString("sbi", mYoubikeDataList.get(position).sbi);
                bundle.putString("lat", mYoubikeDataList.get(position).lat);
                bundle.putString("lng", mYoubikeDataList.get(position).lng);
                bundle.putString("ar", mYoubikeDataList.get(position).ar);
                bundle.putString("bemp", mYoubikeDataList.get(position).bemp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}
