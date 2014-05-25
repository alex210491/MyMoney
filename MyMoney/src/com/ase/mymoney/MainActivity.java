package com.ase.mymoney;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ase.mymoney.models.User;
import com.ase.mymoney.ui.InregistrareUser;
import com.ase.mymoney.utils.CommonUtils;

public class MainActivity extends BaseActivity {

	User mUser;
	TextView currencyText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		CurrencyUpdater currencyUpdater = new CurrencyUpdater();
		currencyUpdater.execute(null, null);
		
		User mUser = User.getCurrentUser();
		
		if( User.getCurrentUser()==null ){ //daca nu sunt inregistrat => forteaza ecranul de inregistrare
			Intent intent = new Intent(this, InregistrareUser.class);
			startActivity(intent);
			finish();
			return;
		}
		
		setContentView(R.layout.activity_main);
		
		currencyText = (TextView) findViewById(R.id.currency_text);

	}
	
	class CurrencyUpdater extends AsyncTask<Void, Void, Void>{

		float currency = 0;
		
		@Override
		protected Void doInBackground(Void... params) {
			try {
				currency = CommonUtils.getEurMultiplier();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			if(currency!=0){
				CommonUtils.saveCurrency(currency);
			}
			
			if(currencyText!=null){
				float currency = CommonUtils.getCurrency();
				currencyText.setText("Currency: EUR = "+currency+" RON");
			}
		}
	}


}
