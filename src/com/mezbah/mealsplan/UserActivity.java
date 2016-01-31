package com.sazid.mealsplan;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserActivity extends Activity {
	
	EditText ename, evalue, eage, eweight,eheight;
	String name, value, unit, uage, uweight,uheight;
	RadioGroup runit;
	RadioButton rmg,rmol;
	Button save;
	int chk = 0;
	
	Context ctx = this;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.user_activity);
		
		ename = (EditText) findViewById(R.id.getname);
		evalue = (EditText) findViewById(R.id.getvalue);
		eage = (EditText) findViewById(R.id.getage);
		eweight = (EditText) findViewById(R.id.getweight);
		eheight = (EditText) findViewById(R.id.getheight);
		runit = (RadioGroup) findViewById(R.id.radiounit);
		rmg = (RadioButton) findViewById(R.id.rdmg);
		rmol = (RadioButton) findViewById(R.id.rdmol);
		save = (Button) findViewById(R.id.btnsave);
		
		rmg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				unit = "mg/dL";
				chk = 1;
				
			}
		});
		
		rmol.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				unit = "mmol/L";
				chk = 1;
				
			}
		});		
		
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				name = ename.getText().toString();
				value = evalue.getText().toString();
				uage = eage.getText().toString();
				uweight = eweight.getText().toString();
				uheight = eheight.getText().toString();
				
				if((ename.getText().toString().equals("")) || evalue.getText().toString().equals("") || (chk == 0)
					|| (eage.getText().toString().equals("")) || (eweight.getText().toString().equals("")) || (eheight.getText().toString().equals("")) ){
					Toast.makeText(getBaseContext(), "Please fill up all information!!", Toast.LENGTH_LONG).show();
				}
				
				else{
					DatabaseOperation db = new DatabaseOperation(ctx);
					db.putInformation(db, name, value, unit, uage, uweight, uheight);
					Toast.makeText(getBaseContext(), "Profile Created!!", Toast.LENGTH_LONG).show();
					finish();
				}
				
			}
		});
		
	}

}
