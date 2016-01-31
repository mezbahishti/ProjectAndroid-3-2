package com.sazid.mealsplan;

import com.sazid.mealsplan.TableData.TableInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class TimeMenu extends Activity {
	
	String u_weight,u_height,bmr,u_age,bodyfat,i_weight;
    double lean_body_mass,body_f;
    int BMR,bmr_initial,b,ex_weight;
	ImageButton im_brk,im_ln,im_dn,im_dr,im_out,im_other;
	ImageButton menuButton;
	Context ctx = this;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_menu);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		u_weight = extras.getString("user_weight");
		u_height = extras.getString("user_height");
		u_age = extras.getString("user_age");
		
		Log.d(u_age, "user age");
		
		int wgt = Integer.parseInt(u_weight);
		
        DatabaseOperation dop = new DatabaseOperation(ctx);
        Cursor cr = dop.getbodyfat(dop,u_age);
        
        cr.moveToFirst();
        if(cr.getCount()>0){
        bodyfat = cr.getString(cr.getColumnIndex(TableInfo.BODY_FAT));
        body_f = Double.parseDouble(bodyfat);
        }
        else 
        body_f = 17.0;
        		
        Log.d(bodyfat, "weight" +wgt );
        
        lean_body_mass = (wgt * (100 - body_f))/100;
        bmr_initial = (int) (370 + (21.6 * lean_body_mass));
        b = bmr_initial/200;
        BMR = b*200;
        Log.d("this", "this is calorie "+BMR);
        
        
        Log.d(bmr, "kilocalori " );
        
        DatabaseOperation dp = new DatabaseOperation(ctx);
        Cursor csr = dp.getidealvalue(dp,u_height);
        csr.moveToFirst();
        if(csr.getCount()>0){
        	i_weight = csr.getString(csr.getColumnIndex(TableInfo.WEIGHT_USER));
        	ex_weight = Integer.parseInt(i_weight);
        }
        else
        	ex_weight = wgt;
        
        if(wgt > ex_weight)
        	BMR = BMR - 200;
        
        
        if(BMR < 1000)
        	BMR = 1000;
        
        bmr = String.valueOf(BMR);
        
		
		addListenerOnButton();
	}

	private void addListenerOnButton() {
		im_brk = (ImageButton) findViewById(R.id.ib_breakfast);
		im_ln = (ImageButton) findViewById(R.id.ib_lunch);
		im_dn = (ImageButton) findViewById(R.id.ib_dinner);
		im_dr = (ImageButton) findViewById(R.id.ib_drinks);
		//im_out = (ImageButton) findViewById(R.id.ib_outdoor);
		im_other = (ImageButton) findViewById(R.id.ib_others);
		
		TranslateAnimation animation = new TranslateAnimation(-400.0f, 0.0f,
				0.0f, 0.0f);
		animation.setDuration(2000);
		animation.setFillAfter(true);
		im_brk.startAnimation(animation);
		
		TranslateAnimation animation2 = new TranslateAnimation(400.0f, 0.0f,
				0.0f, 0.0f);
		animation2.setDuration(2000);
		animation2.setFillAfter(true);
		im_ln.startAnimation(animation2);
		
		TranslateAnimation animation3 = new TranslateAnimation(-400.0f, 0.0f,
				0.0f, 0.0f);
		animation3.setDuration(2000);
		animation3.setFillAfter(true);
		im_dn.startAnimation(animation3);
		
		TranslateAnimation animation4 = new TranslateAnimation(400.0f, 0.0f,
				0.0f, 0.0f);
		animation4.setDuration(2000);
		animation4.setFillAfter(true);
		im_dr.startAnimation(animation4);
		
		TranslateAnimation animation5 = new TranslateAnimation(-400.0f, 0.0f,
				0.0f, 0.0f);
		animation5.setDuration(2000);
		//animation5.setRepeatCount(1);
		// animation.setRepeatMode(2);
		animation5.setFillAfter(true);
		//im_out.startAnimation(animation5);
		
		TranslateAnimation animation6 = new TranslateAnimation(-400.0f, 0.0f,
				0.0f, 0.0f);
		animation6.setDuration(2000);
		//animation6.setRepeatCount(1);
		// animation.setRepeatMode(2);
		animation6.setFillAfter(true);
		im_other.startAnimation(animation6);
		
	}
	
	public void findButton(View bid){
		menuButton =  (ImageButton) bid;
		int btnId = menuButton.getId();
		Intent intent = new Intent(ctx, FoodMenu.class);
		intent.putExtra("button_Id", btnId);
		intent.putExtra("u_bmr", bmr);
		startActivity(intent);
		
	}

}
