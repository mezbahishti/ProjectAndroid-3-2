package com.sazid.mealsplan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ManageAlarm extends Activity {

	DatePicker pickerDate;
	TimePicker pickerTime;
	Button buttonSetAlarm;
	TextView info;
	String name;

	final static int RQS_1 = 1;
	DBforAlarm dalarm = new DBforAlarm(this);
	TextView tal;
	String txForAlarm="Alarm set at: ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.managealarm);
		 tal=(TextView) findViewById(R.id.textalarm);


		Intent ii = getIntent();
		Bundle extras = ii.getExtras();
		name = extras.getString("user");
		String us_name;
		String time = null;


		SQLiteDatabase sdb=dalarm.getReadableDatabase();
		Cursor cursor=sdb.query(dalarm.TABLE_NAME, null, null, null, null, null, null);
		if(cursor!=null && cursor.getCount()>0){

		while(cursor.moveToNext()){
			
			us_name=cursor.getString(0);
			if(us_name.equals(name)){
				
				time=cursor.getString(2);
				break;
			}


		}

		txForAlarm=txForAlarm+time;
		tal.setText(txForAlarm);
		}
		else
		txForAlarm=txForAlarm+" No alarm set yet.";
		tal.setText(txForAlarm);

		cursor.close();
		sdb.close();









		pickerDate = (DatePicker) findViewById(R.id.pickerdate);
		pickerTime = (TimePicker) findViewById(R.id.pickertime);

		Calendar now = Calendar.getInstance();

		pickerDate.init(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), null);

		pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
		pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

		buttonSetAlarm = (Button) findViewById(R.id.setalarm);
		buttonSetAlarm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, pickerDate.getYear());
				calendar.set(Calendar.MONTH, pickerDate.getMonth());
				calendar.set(Calendar.DAY_OF_MONTH, pickerDate.getDayOfMonth());
				calendar.set(Calendar.HOUR_OF_DAY, pickerTime.getCurrentHour());
				calendar.set(Calendar.MINUTE, pickerTime.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);

				Calendar current = Calendar.getInstance();

				if (calendar.compareTo(current) <= 0) {
					// The set Date/Time already passed
					Toast.makeText(getApplicationContext(),
							"Invalid Date/Time", Toast.LENGTH_LONG).show();
				} else {

					String x = "alarm at:" + calendar.getTime();
					// Toast.makeText(getApplicationContext(),
					// "id="+id+" for:"+name,
					// /Toast.LENGTH_LONG).show();
					//Log.d("Db",""+id);

					setAlarm(calendar);
					finish();

				}

			}
		});
	}

	public void setAlarm(Calendar targetCal) {


		int rawid = (int) targetCal.getTimeInMillis();

		int mid = (int) TimeUnit.MILLISECONDS.toMinutes(rawid);
		String id = Long.toString(mid);

		Intent intent = new Intent();
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		intent.setClass(this, MyAlarmService.class);
		intent.setAction(Long.toString(System.currentTimeMillis()));
		PendingIntent pendingIntent = PendingIntent.getService(this, mid, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
				pendingIntent);


		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date spdate = targetCal.getTime();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String reportDate = df.format(spdate);

		// Print what date is today!
		Log.d("time", reportDate);








		SQLiteDatabase sd = dalarm.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(dalarm.TABLE_ID, id);
		cv.put(dalarm.TABLE_USER, name);
		cv.put(dalarm.TABLE_TIME, reportDate);
		sd.insert(dalarm.TABLE_NAME, dalarm.TABLE_ID, cv);
		cv.clear();
		sd.close();
		dalarm.close();
		

	}
}
