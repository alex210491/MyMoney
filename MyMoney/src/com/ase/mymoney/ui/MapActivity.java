package com.ase.mymoney.ui;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends BaseActivity{
	
	private GoogleMap mMap;
	private LocationManager mLocationManager;
	private List<Expance> mExpanceList;
	private Location mMyLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.map_activity);
		
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		mMyLocation = getMyLocation();
		
		initMap();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setupMarkers();
	}
	
	private void initMap(){
		if(mMap==null) return;
		
		mMap.setMyLocationEnabled(true);
		
		if (mMyLocation != null) {
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mMyLocation.getLatitude(), mMyLocation.getLongitude()), 10));
		}
	}
	
	private void setupMarkers(){
		mExpanceList = BaseActivity.dbHelper.getAllExpance();
		for(Expance e : mExpanceList){
			LatLng location = new LatLng(e.getLatitude(), e.getLongitude());
			MarkerOptions markerOption = new MarkerOptions();
			markerOption.position(location);
			markerOption.icon(BitmapDescriptorFactory.defaultMarker());
			mMap.addMarker(markerOption);
		}
	}
	
	private Location getMyLocation(){
		Location myLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(myLocation!=null) return myLocation;
		myLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		return myLocation;
	}
	
}
