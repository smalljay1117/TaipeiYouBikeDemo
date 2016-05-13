package com.example.smalljay1117.taipeiyoubikedemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.smalljay1117.taipeiyoubikedemo.util.JSONUtility;
import com.example.smalljay1117.taipeiyoubikedemo.util.TaipeiYoubikeUtil;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TaipeiYoubikeTask taipeiYoubikeTask;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (taipeiYoubikeTask != null) {
            taipeiYoubikeTask.cancel(true);
        }
        taipeiYoubikeTask = new TaipeiYoubikeTask();
        taipeiYoubikeTask.execute();
    }

    private class TaipeiYoubikeTask extends AsyncTask<Object, Object, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //讀取動畫
                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.show();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override
        protected String doInBackground(Object... params) {
            String result = TaipeiYoubikeUtil.getTaipeiYoubikes();
            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //關閉讀取動畫
                    progressDialog.dismiss();
                }
            });
            JSONObject json = JSONUtility.getJSONObject(result);
            String strJson = JSONUtility.getStringFromJSONObject(json, "retVal");

            Intent intent = new Intent(MainActivity.this, TaipeiYoubikeHome.class);
            intent.putExtra("json", strJson);
            startActivity(intent);
            finish();
            super.onPostExecute(result);
        }
    }
}
