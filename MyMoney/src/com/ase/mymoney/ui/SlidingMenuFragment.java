package com.ase.mymoney.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;

public class SlidingMenuFragment extends Fragment {
	
	private TextView expanceTypesButton;
	private TextView myProfileButton;
	
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
		
		
		expanceTypesButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ExpanceTypesActivity.class);
				startActivity(intent);
			}
		});
		
		myProfileButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), MyProfil.class);
				startActivity(intent);
			}
		});
		
		
		
		
		
	}
	
}
