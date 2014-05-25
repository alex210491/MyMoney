package com.ase.mymoney.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;
import com.ase.mymoney.ui.ExpanceAddWizardDialogFragment.ExpanceUpdater;
import com.ase.mymoney.utils.CommonUtils;

public class ExpanceAddFragmentStep1 extends Fragment implements ExpanceUpdater{
	
	private TextView mExpanceSum;
	private Spinner mExpanceUnit;
	private CheckBox checkboxSaveLocation;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.expance_add_fragment_1, null);
		return root;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		mExpanceUnit = (Spinner) view.findViewById(R.id.inputExpanceUnit);
		mExpanceSum = (TextView) view.findViewById(R.id.inputExpanceSum);
		checkboxSaveLocation = (CheckBox) view.findViewById(R.id.saveLocation);
		
		List<String> list = new ArrayList<String>();
		list.add("RON");
		list.add("EUR");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
		mExpanceUnit.setAdapter(adapter);
		
		
		
		//pune expance type-urile in spinner
		//pune valorile in mExpance din wizard
		//fa next etc
	}

	@Override
	public Expance updateExpance(Expance expance) {
		String um = (String) mExpanceUnit.getSelectedItem();
		int monetaryUnit = CommonUtils.getUM(um);
		try{
			expance.setSum(Float.parseFloat(mExpanceSum.getText().toString()));
		}catch(NumberFormatException e){
			expance.setSum(0);
		}
		
		if(checkboxSaveLocation.isChecked()){
			Location myLocation = getMyLocation();
			if(myLocation!=null){
				expance.setLatitude((float)myLocation.getLatitude());
				expance.setLongitude((float)myLocation.getLongitude());
			}
		}
		
		expance.setUm(monetaryUnit);
		return expance;
	}
	
	private Location getMyLocation(){
		LocationManager  locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);  
		Location myLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(myLocation!=null) return myLocation;
		myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		return myLocation;
	}
	
}
