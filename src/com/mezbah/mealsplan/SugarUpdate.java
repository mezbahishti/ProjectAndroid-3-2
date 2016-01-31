package com.sazid.mealsplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SugarUpdate extends Activity {

	String val,unit,u_name,s_level,us_id, u_weight,u_age,u_height;
	EditText value, eweight,eheight,eage;
	RadioGroup runit;
	RadioButton rmg, rmol;
	Button update;
	int chk;
	Context ctx = this;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sugar_update);
		
		value = (EditText) findViewById(R.id.update_value);
		eage = (EditText) findViewById(R.id.update_age);
		eweight = (EditText) findViewById(R.id.update_weight);
		eheight = (EditText) findViewById(R.id.update_height);
		runit = (RadioGroup) findViewById(R.id.radiounit);
		rmg = (RadioButton) findViewById(R.id.rdmg);
		rmol = (RadioButton) findViewById(R.id.rdmol);
		update = (Button) findViewById(R.id.update_s_level);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		if(extras != null){
		s_level = extras.getString("sugar_level");
		u_name = extras.getString("pro_name");
		us_id = extras.getString("u_id");
		}
		
		Log.d(us_id, "userid_level");
		
		rmg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				unit = "mg/dL";		
				chk = 1;
			}
		});
		rmol.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unit = "mmol/L";
				chk = 1;				
			}
			
		});
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				val = value.getText().toString();
				u_age = eage.getText().toString();
				u_weight = eweight.getText().toString();
				u_height = eheight.getText().toString();
				Log.d(val, "value");
				
				if( value.getText().toString().equals("") || (chk == 0) || eweight.getText().toString().equals("")
						|| eheight.getText().toString().equals("") || eage.getText().toString().equals("")){
					Toast.makeText(ctx, "all field required!!", Toast.LENGTH_LONG).show();

				}
				
				else {
					DatabaseOperation db = new DatabaseOperation(ctx);
					db.updateInformation(db, u_name, us_id, val, unit, u_age, u_weight, u_height);
					Toast.makeText(ctx, "Value Updated", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(ctx, DailyMenu.class);
					intent.putExtra("userid", us_id);
					intent.putExtra("pro_name", u_name);
					startActivity(intent);
					finish();
				}
			}
		});
		
		
	}
}
