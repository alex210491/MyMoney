package com.ase.mymoney.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.ExpanceType;

public class ExpanceTypeAddFragmentDialog extends DialogFragment {
	
	private EditText mInputTitle;
	private Button mAddButton;
	private OnExpanceTypeAddListener mListener;

	public interface OnExpanceTypeAddListener {
		public void onExpanceTypeAdded(ExpanceType e);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mListener = (OnExpanceTypeAddListener) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View root = inflater.inflate(R.layout.expance_type_add_layout, null);

		return root;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		getDialog().setTitle("Add Expance Type");
		
		mInputTitle = (EditText) view.findViewById(R.id.inputTitle);
		mAddButton = (Button) view.findViewById(R.id.add_button);
		
		mAddButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String title = mInputTitle.getText().toString();
				ExpanceType e = new ExpanceType(title, 0);
				BaseActivity.dbHelper.addExpanceType(e);
				mListener.onExpanceTypeAdded(e);
				dismiss();
			}
		});
	}
}
