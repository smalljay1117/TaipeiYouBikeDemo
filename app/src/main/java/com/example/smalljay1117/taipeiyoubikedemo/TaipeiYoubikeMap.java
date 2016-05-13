package com.example.smalljay1117.taipeiyoubikedemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TaipeiYoubikeMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double mLat, mLng;
    private String mTot, mSbi, mAr, mBemp;
    private TextView mTvTot, mTvSbi, mTvAr, mTvBemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youbike_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        mTvTot = (TextView) findViewById(R.id.tv_tot);
        mTvSbi = (TextView) findViewById(R.id.tv_sbi);
        mTvAr = (TextView) findViewById(R.id.tv_ar);
        mTvBemp = (TextView) findViewById(R.id.tv_bemp);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            setTitle(bundle.getString("sna"));
            mTot = bundle.getString("tot");
            mSbi = bundle.getString("sbi");
            mAr = bundle.getString("ar");
            mBemp = bundle.getString("bemp");
            mLat = Double.parseDouble(bundle.getString("lat"));
            mLng = Double.parseDouble(bundle.getString("lng"));
        }
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        mMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        LatLng sydney = new LatLng(mLat, mLng);
        mMap.addMarker(new MarkerOptions().position(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));

        mTvAr.setText(mAr);
        mTvTot.setText(mTot);
        mTvSbi.setText(mSbi);
        mTvBemp.setText(mBemp);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
