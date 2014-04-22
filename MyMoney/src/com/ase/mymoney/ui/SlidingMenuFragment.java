package com.ase.mymoney.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ase.mymoney.R;

public class SlidingMenuFragment extends Fragment {
	
	private TextView expanceTypesButton;
	private TextView myProfileButton;
	private TextView expanceButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View root = inflater.inflate(R.layout.sliding_menu_layout, null);
		
		return root;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		expanceTypesButton = (TextView) view.findViewById(R.id.expanceTypeBtn);
		myProfileButton = (TextView) view.findViewById(R.id.myProfileBtn);
		expanceButton = (TextView) view.findViewById(R.id.expanceBtn);
		
		expanceTypesButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ExpanceTypesActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); //the activity will not be launched if it is already running at the top of the history stack
				startActivity(intent);
			}
		});
		
		myProfileButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), MyProfil.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);
			}
		});
		
		expanceButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ExpanceActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);
			}
		});
		
		
		
	}
	
}
