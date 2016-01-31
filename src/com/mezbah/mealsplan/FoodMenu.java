package com.sazid.mealsplan;



import com.sazid.mealsplan.TableData.TableInfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FoodMenu extends Activity {
         
	String user_bmr,category;
	ListView lview;
	Context ctx = this;
	    String[] breakfast = { "Potato" ,"Bread","Bread Roll","Egg", "Puffed Rice" ,"Salt Biscuit","Fruits","Corn","Vegetables"};
        String[] lunch = { "Rice","Chicken","Beef","Fish","Peas","vegetables"};
		String[] drinks = {"Apple juice","Orange juice","Grape juice","Papaya juice","Watermelon juice","Mango juice","Guava juice","Malta juice","Banana juice"};
		String[] other = {"Milk" ,"Peanut","Peas","Chickpea","Noddles"};
		String[] dinner = {"Bread","Fish","Meat","Peas","Egg","Vegetables"};
		String[] fastfoods = {"pizza","Burger","Hot Dog","Cheese","French fry","Chicken fry","soup(chicken)","soup(thai)","Chopstics"};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_menu);
		
		
	 lview = (ListView) findViewById(R.id.listFood); 
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		if(extras != null){
			int specificButton = extras.getInt("button_Id");
			user_bmr = extras.getString("u_bmr");
			//Log.d(user_bmr, "kilokari");
			
			
			switch(specificButton){			
			case R.id.ib_breakfast:
			{
			
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_multiple_choice, breakfast);
				lview.setAdapter(adapter);	
				lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				category = "breakfast";
				Log.d(user_bmr, "this is breakfast");
				break;
			}
			
			case R.id.ib_lunch:
			{
				
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_multiple_choice, lunch);
				lview.setAdapter(adapter);
				lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				category = "lunch";
				Log.d(user_bmr, "this is lunch");
				break;
			}
			
			case R.id.ib_dinner:
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_multiple_choice, dinner);
				lview.setAdapter(adapter);
				lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				category = "dinner";
				break;
			}
			case R.id.ib_drinks:
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_multiple_choice, drinks);
				lview.setAdapter(adapter);
				lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				category = "afternoon";
				break;
			}
			
			case R.id.ib_others:
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_multiple_choice, other);
				lview.setAdapter(adapter);
				lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				category = "afternoon";
				break;
			}
			}
			
		
		}
		
		
	}
	
//DONE create
	public boolean onCreateOptionsMenu(Menu menu) {
		//ActionBar inflater=getActionBar();
	   MenuInflater inflater = getMenuInflater();
	   
	    ((MenuInflater) inflater).inflate(R.menu.mymenu, menu);
	    
	    return true;
	}
	//DONE listener
	
	public boolean onOptionsItemSelected(MenuItem item) {
		String selected="";
		String itm;
		int len=lview.getCount();
		SparseBooleanArray checked=lview.getCheckedItemPositions();
		
	    for(int i = 0; i < len; i++){
	    	 
            if(checked.get(i)) {

                
                String name = lview.getItemAtPosition(i).toString();
                DatabaseOperation dop = new DatabaseOperation(ctx);
                Cursor cr = dop.getitemdetails(dop,category,name,user_bmr);
                cr.moveToFirst();
                itm = cr.getString(0);
                selected += lview.getItemAtPosition(i).toString() +": "+itm+ "\n";
                Log.d(itm, "item value");
                
                
            }

        }
        
	    AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Details");
        alertDialog.setMessage(selected);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(final DialogInterface dialog, final int which) {
       	           
        }
        });
        alertDialog.show();
        //Toast.makeText(FoodMenu.this, selected, Toast.LENGTH_LONG).show();
		
		return super.onOptionsItemSelected(item);
	}

}


