package com.example.smalljay1117.taipeiyoubikedemo.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class TaipeiYoubikeUtil {

    public static String getTaipeiYoubikes() {
        String buffer = "";

        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
        HttpConnectionParams.setSoTimeout(httpParams, 10000);
        DefaultHttpClient client = new DefaultHttpClient(httpParams);
        GZIPInputStream gzin;
        try {
            HttpGet get = new HttpGet("http://data.taipei/youbike");
            HttpResponse response = client.execute(get);
            gzin = new GZIPInputStream(response.getEntity().getContent());
            InputStreamReader isr = new InputStreamReader(gzin, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            buffer = br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return buffer;
    }
}
