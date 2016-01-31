package com.sazid.mealsplan;

import java.util.concurrent.TimeUnit;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyAlarmService extends Service {
	// ManageAlarm ma=new ManageAlarm();

	private NotificationManager mManager;
	int rid;
	
	
	public int onStartCommand(Intent intent, int flags, int startId) {
	
		// reading database of alarm
		DBforAlarm da = new DBforAlarm(this);
		SQLiteDatabase sd = da.getReadableDatabase();
		Cursor cursor = sd.query(da.TABLE_NAME, null, null, null, null, null,
				null);
		int  time = (int) System.currentTimeMillis();
		rid = (int) TimeUnit.MILLISECONDS.toMinutes(time);
		String id = Long.toString(rid);
		String did = null;
		String theName = null;
		Log.d("Dara", "starts");

		while (cursor.moveToNext()) {

			did = cursor.getString(1);
			Log.d("tdb", cursor.getString(2));

			if (did.equals(id)) {
				theName = cursor.getString(0);
				break;

			}

			Log.d("Dbid", "" + did);
			Log.d("systemid", "" + id);
			Log.d("na", theName);

		}

		cursor.close();

		sd.close();
		// deleting the alarm
		SQLiteDatabase nsd = da.getWritableDatabase();
		String[] args = { theName };
		nsd.delete(da.TABLE_NAME, da.TABLE_USER + "=?", args);
		nsd.close();

		da.close();
		// got name

		NotificationManager notiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Intent notiIntent = new Intent(this, MainActivity.class);
		notiIntent.putExtra("id", rid);
		PendingIntent penIntent = PendingIntent.getActivity(this, 0,
				notiIntent, 0);
		Notification notific = new Notification(R.drawable.ic_launcher,
				"Time to see the doctor", System.currentTimeMillis());

		notific.defaults |= Notification.DEFAULT_SOUND;
		notific.defaults |= Notification.DEFAULT_LIGHTS;
		notific.defaults |= Notification.DEFAULT_VIBRATE;

		notific.setLatestEventInfo(this, theName, "Time to see Doctor",
				penIntent);
		notiManager.notify(0, notific);
		cancel();
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	public void cancel()
	{
		
		AlarmManager am=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
		Intent intent=new Intent();
		PendingIntent pintent=PendingIntent.getService(this, rid, intent, 0);
		am.cancel(pintent);
		Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@SuppressWarnings("static-access")
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);


		//Toast.makeText(this, "canceled", Toast.LENGTH_LONG).show();



	}

	@Override
	public void onDestroy() {

	



		// TODO Auto-generated method stub
		super.onDestroy();
	}


}
