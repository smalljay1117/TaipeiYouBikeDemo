package com.example.smalljay1117.taipeiyoubikedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smalljay1117.taipeiyoubikedemo.data.TaipeiYoubikeData;

import java.util.ArrayList;

public class TaipeiYoubikeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TaipeiYoubikeData> mYoubikeDataList;

    public TaipeiYoubikeAdapter(Context context, ArrayList<TaipeiYoubikeData> mYoubikeDataList) {
        this.context = context;
        this.mYoubikeDataList = mYoubikeDataList;
    }

    @Override
    public int getCount() {
        return mYoubikeDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mYoubikeDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_youbike, null);

            viewHolder = new ViewHolder();
            viewHolder.mTvSna = (TextView) convertView.findViewById(R.id.tv_sna);
            viewHolder.mTvSbi = (TextView) convertView.findViewById(R.id.tv_sbi);
            viewHolder.mTVBemp = (TextView) convertView.findViewById(R.id.tv_bemp);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTvSna.setText(mYoubikeDataList.get(position).sna);
        viewHolder.mTvSbi.setText(mYoubikeDataList.get(position).sbi);
        viewHolder.mTVBemp.setText(mYoubikeDataList.get(position).bemp);

        return convertView;
    }

    private class ViewHolder {
        TextView mTvSna;
        TextView mTvSbi;
        TextView mTVBemp;
    }
}
