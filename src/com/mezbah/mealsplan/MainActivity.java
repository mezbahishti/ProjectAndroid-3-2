package com.sazid.mealsplan;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		
		NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		nm.cancelAll();
		buttonlistener();
	}

	private void buttonlistener() {
		Button btncreate = (Button) findViewById(R.id.btn1);
		Button btnexist = (Button) findViewById(R.id.btn2);
		
		final Context context = this;
		
		btncreate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);	
                startActivity(intent);
			}
		});
		
		btnexist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, TotalUser.class);
				startActivity(intent);
				
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
