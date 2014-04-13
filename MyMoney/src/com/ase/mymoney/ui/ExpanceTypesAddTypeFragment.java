package com.ase.mymoney.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
 
public class ExpanceTypesAddTypeFragment extends DialogFragment {
  
 @Override
 public Dialog onCreateDialog(Bundle savedInstanceState) {
   
  OnClickListener positiveClick = new OnClickListener() {   
   @Override
   public void onClick(DialogInterface dialog, int which) {    
    Toast.makeText(getActivity().getBaseContext(), "Application finishing ...", Toast.LENGTH_SHORT).show();
    getActivity().finish();    
   }
  };
   
  OnClickListener negativeClick = new OnClickListener() {   
   @Override
   public void onClick(DialogInterface dialog, int which) {
    Toast.makeText(getActivity().getBaseContext(), "No option selecting", Toast.LENGTH_SHORT).show();
     
   }
  };
 
  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
  builder.setMessage("Do you want Yes or No ?");
  builder.setNegativeButton("No", negativeClick);
  builder.setPositiveButton("Yes", positiveClick);
  builder.setTitle("Confirmation");
  Dialog dialog = builder.create();
  return dialog;
 }
 
}
