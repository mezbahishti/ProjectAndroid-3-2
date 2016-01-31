package com.sazid.mealsplan;

import com.sazid.mealsplan.TableData.TableInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TotalUser extends Activity {

	String user_level,user_unit,user_name,user_id,user_age,user_weight,user_height;
	int pos_str;
	Context ctx = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.total_user);
		
		DatabaseOperation db = new DatabaseOperation(ctx);
		Cursor cr = db.getInformation(db);
		cr.moveToFirst();
		String[] names = new String[cr.getCount()];
		
		if(cr.getCount()>0){
			int i=0;
			String tem_name;
			do{
				tem_name = cr.getString(cr.getColumnIndex(TableInfo.USER_NAME));
				names[i] = tem_name;
				i++;
			}while(cr.moveToNext());
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, names);
			ListView listview = (ListView) findViewById(R.id.lv_user);
			listview.setAdapter(adapter);
		}
		
		else{
			Toast.makeText(getBaseContext(), "No User available!!", Toast.LENGTH_LONG).show();
			finish();
		}
		
		ListView tlv = (ListView) findViewById(R.id.lv_user);
		tlv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				
				final String data =(String)parent.getItemAtPosition(position);
				pos_str = 1;
				pos_str = pos_str + position;
				String pos_id = String.valueOf(pos_str);
				Log.d(data, "this is a string");
				Log.d(pos_id, "this is a string " +pos_str);
				
				DatabaseOperation dop = new DatabaseOperation(ctx);
	    		Cursor cor = dop.getdetails(dop,data,pos_id);
	            cor.moveToFirst();
	            user_id = cor.getString(cor.getColumnIndex(TableInfo._ID));
	            user_unit = cor.getString(cor.getColumnIndex(TableInfo.UNIT));
	            user_level = cor.getString(cor.getColumnIndex(TableInfo.SUGAR_LEVEL));
	            user_name = cor.getString(cor.getColumnIndex(TableInfo.USER_NAME));
	            user_age = cor.getString(cor.getColumnIndex(TableInfo.AGE));
	            user_weight = cor.getString(cor.getColumnIndex(TableInfo.WEIGHT));
	            user_height = cor.getString(cor.getColumnIndex(TableInfo.HEIGHT));
	            //Log.d(user_age, "user age");
	           
	            
	            

				
				if(position >= 0){
					
					Intent intent = new Intent(ctx, DailyMenu.class);
					intent.putExtra("pro_name", user_name);
					intent.putExtra("sugar_level", user_level);
					intent.putExtra("unit_mol", user_unit);
					intent.putExtra("userid", user_id);
					intent.putExtra("u_weight", user_weight);
					intent.putExtra("u_height", user_height);
					
					startActivity(intent);
				}
			}           
			
		});
	}
}
