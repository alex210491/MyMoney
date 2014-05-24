package com.ase.mymoney.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;

public class ExpanceAddWizardDialogFragment extends DialogFragment{
	
	public static final String TAG = "EXPANCE_ADD_WIZARD";
	
	private TextView mCancelButton, mNextButton;
	private int mWizardStep=0;
	private Expance mExpance;
	private FragmentManager mFragmentManager;
	private ExpanceUpdater mExpanceUpdater;
	private OnExpanceAddListener onExpanceAddListener;
	
	
	public interface OnExpanceAddListener{
		public void onExpanceAdded(Expance expance);
	}
	
	public interface ExpanceUpdater{
		public Expance updateExpance(Expance expance);
	}
	
	@Override
	public void onAttach(Activity activity) {
		onExpanceAddListener = (OnExpanceAddListener) activity;
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mExpance = new Expance();
		mFragmentManager = getChildFragmentManager();
		
		
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
		initDialogFragment(view);
	}
	
	private void initDialogFragment(View view){
		this.setCancelable(false);
		this.getDialog().setTitle(getString(R.string.add_expance_wizard));
		
		ExpanceAddFragmentStep0 fragment = new ExpanceAddFragmentStep0();
		mExpanceUpdater = fragment;
		mFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit();
		
		mCancelButton = (TextView) view.findViewById(R.id.cancelButton);
		mNextButton = (TextView) view.findViewById(R.id.nextButton);
		
		mCancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		
		mNextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handleNextButtonAction();
			}
		});
	}
	
	private void handleNextButtonAction(){
		
		switch (mWizardStep) {
		case 0:
			mExpance = mExpanceUpdater.updateExpance(mExpance);
			
			if(mExpance.getTitle()==null || mExpance.getTitle().isEmpty()){
				Toast.makeText(getActivity(), "Invalid title", Toast.LENGTH_SHORT).show();
				return;
			}
			if(mExpance.getExpanceTypeId()==-1){
				Toast.makeText(getActivity(), "Select an expance type", Toast.LENGTH_SHORT).show();
				return;
			}
			
			ExpanceAddFragmentStep1 fragment = new ExpanceAddFragmentStep1();
			mExpanceUpdater = fragment;
			mFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit();
			
			mNextButton.setText(getString(R.string.finish));
			break;

		case 1:
			mExpance = mExpanceUpdater.updateExpance(mExpance);
			if(mExpance.getSum()==0){
				Toast.makeText(getActivity(), "Invalid price", Toast.LENGTH_SHORT).show();
				return;
			}
			long id = BaseActivity.dbHelper.addExpance(mExpance);
			onExpanceAddListener.onExpanceAdded(mExpance);
			dismiss();
			break;
		default:
			break;
		}
		
		mWizardStep++;
	}
}
