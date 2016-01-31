package com.sazid.mealsplan;

import com.sazid.mealsplan.TableData.TableInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DailyMenu extends Activity {
	
	Button menuButton;
	Button reminder_btn,update,t_menu;
	String const_level, usernam,u_id,user_level,user_unit,user_name,user_id,u_age,u_weight,u_height,unam;
	Context ctx = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailymenu); 
		
		TextView sug_lev = (TextView) findViewById(R.id.suger);
		TextView name=(TextView) findViewById(R.id.name);
		
		String slevel = "Your Current Sugar Level : ";
		String pname = "Your Profile : ";
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		u_id = extras.getString("userid");
		unam=extras.getString("pro_name");
		
		 DatabaseOperation dop = new DatabaseOperation(ctx);
		 Cursor cor = dop.getdetailsUser(dop,u_id);
		 cor.moveToFirst();
         user_id = cor.getString(cor.getColumnIndex(TableInfo._ID));
         user_unit = cor.getString(cor.getColumnIndex(TableInfo.UNIT));
         user_level = cor.getString(cor.getColumnIndex(TableInfo.SUGAR_LEVEL));
         user_name = cor.getString(cor.getColumnIndex(TableInfo.USER_NAME));
         u_age = cor.getString(cor.getColumnIndex(TableInfo.AGE));
         u_height = cor.getString(cor.getColumnIndex(TableInfo.HEIGHT));
		
		if(extras != null){
			DatabaseOperation dop_v = new DatabaseOperation(ctx);
		    Cursor cor_v = dop_v.getdetailsUser(dop,u_id);
		    cor_v.moveToFirst();
		    //user_id = cor.getString(cor.getColumnIndex(TableInfo._ID));
		    //user_level = cor.getString(cor.getColumnIndex(TableInfo.SUGAR_LEVEL));
		    //user_unit = cor.getString(cor.getColumnIndex(TableInfo.UNIT));
		    u_weight = cor.getString(cor.getColumnIndex(TableInfo.WEIGHT));
		    			
		}
		
		slevel = slevel + user_level + user_unit;
		pname=pname + extras.getString("pro_name");
		sug_lev.setText(slevel);
	    name.setText(pname);
		
		reminder_btn=(Button) findViewById(R.id.reminder);
		update = (Button) findViewById(R.id.update_level);
		t_menu = (Button) findViewById(R.id.choose_meal);
		
		
		t_menu.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ctx, TimeMenu.class);
				intent.putExtra("user_weight", u_weight);
				intent.putExtra("user_height", u_height);
				intent.putExtra("user_age", u_age);
				startActivity(intent);
				
			}
		});
		
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ctx, SugarUpdate.class);
				intent.putExtra("sugar_level", user_level);
				intent.putExtra("pro_name", user_name);
				intent.putExtra("u_id", user_id);
				startActivity(intent);
				finish();
				
			}
		});
		reminder_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent=new Intent(DailyMenu.this, ManageAlarm.class);
				intent.putExtra("user", unam);
				
				startActivity(intent);
			}
		});
	}
	
	
	public void findButton(View bid){
		menuButton = (Button) bid;
		int btnId = menuButton.getId();
		Intent intent = new Intent(ctx, FoodMenu.class);
		intent.putExtra("button_Id", btnId);
		startActivity(intent);
		
	}

}
