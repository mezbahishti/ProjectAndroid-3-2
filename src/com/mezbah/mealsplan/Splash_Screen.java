package com.sazid.mealsplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends Activity {
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);

        final Intent intent = new Intent(this, MainActivity.class);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {

            	
                startActivity(intent);
                finish();
                overridePendingTransition(R.layout.fadein, R.layout.fadeout);
            }
        }, 3000);
	}

}
