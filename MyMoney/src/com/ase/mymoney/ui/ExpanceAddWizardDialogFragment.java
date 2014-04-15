package com.ase.mymoney.ui;

import com.ase.mymoney.R;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExpanceAddWizardDialogFragment extends DialogFragment {
	
	public static final String TAG = "EXPANCE_ADD_WIZARD";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.expance_add_wizard_dialog_fragment, null);
		return root;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initDialogFragment();
	}
	
	private void initDialogFragment(){
		this.setCancelable(false);
		this.getDialog().setTitle(getString(R.string.add_expance_wizard));
	}
}
