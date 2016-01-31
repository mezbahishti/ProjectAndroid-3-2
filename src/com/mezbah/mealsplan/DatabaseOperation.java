package com.sazid.mealsplan;

import com.sazid.mealsplan.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DatabaseOperation extends SQLiteOpenHelper implements BaseColumns 
{

	
	public static final String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+ "( " +
	_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	TableInfo.USER_NAME+ " TEXT, " +
	TableInfo.SUGAR_LEVEL+ " TEXT, "+
	TableInfo.UNIT+ " TEXT, "+
	TableInfo.AGE+ " TEXT, "+
	TableInfo.WEIGHT+ " TEXT, "+
	TableInfo.HEIGHT+ " TEXT "+
	") ";
	
	public static final  String CREATE_QUERY_BREAKFAST = "CREATE TABLE "+TableInfo.TABLE_NAME_BREAKFAST+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.CALORIE_B+ " TEXT, " +
			TableInfo.BREAD_B+ " TEXT, " +
			TableInfo.BREAD_ROLL_B+ " TEXT, " +
			TableInfo.EGG_B+ " TEXT, "+
			TableInfo.PUFFED_RICE_B+ " TEXT, "+
			TableInfo.BISCUIT_B+ " TEXT, "+
			TableInfo.VEGETABLES_B+ " TEXT, "+
			TableInfo.FRUITS_B+ " TEXT, "+
			TableInfo.POTATO_B+" TEXT, "+
			TableInfo.CORN_B+" TEXT "+
			") ";
	public static final  String CREATE_QUERY_LUNCH = "CREATE TABLE "+TableInfo.TABLE_NAME_LUNCH+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.CALORIE_L+ " TEXT, " +
			TableInfo.RICE_L+ " TEXT, " +
			TableInfo.FISH_L+ " TEXT, "+
			TableInfo.CHICKEN_L+ " TEXT, "+
			TableInfo.BEEF_L+ " TEXT, "+
			TableInfo.PEAS_L+ " TEXT, "+
			TableInfo.VEGETABLES_L+ " TEXT "+
			") ";	
	public static final  String CREATE_QUERY_NOON = "CREATE TABLE "+TableInfo.TABLE_NAME_NOON+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.CALORIE_N+ " TEXT, " +
			TableInfo.MILK_N+ " TEXT, " +
			TableInfo.PEANUT_N+ " TEXT, "+
			TableInfo.PEAS_N+ " TEXT, "+
			TableInfo.CHICKPEA_N+ " TEXT, "+
			TableInfo.NODDLES_N+ " TEXT, "+
			TableInfo.PAPAYA+ " TEXT, "+
			TableInfo.GUAVA+ " TEXT, "+
			TableInfo.MANGO+ " TEXT, "+
			TableInfo.ORANGE+ " TEXT, "+
			TableInfo.MALTA+ " TEXT, "+
			TableInfo.WATER_MELON+ " TEXT, "+
			TableInfo.GRAPES+ " TEXT, "+
			TableInfo.BANANA+ " TEXT, "+
			TableInfo.APPLE+ " TEXT "+
			") ";
	public static final  String CREATE_QUERY_DINNER = "CREATE TABLE "+TableInfo.TABLE_NAME_DINNER+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.CALORIE_D+ " TEXT, " +
			TableInfo.BREAD_D+ " TEXT, " +
			TableInfo.FISH_D+ " TEXT, "+
			TableInfo.MEAT_D+ " TEXT, "+
			TableInfo.PEAS_D+ " TEXT, "+
			TableInfo.VEGETABLES_D+ " TEXT, "+
			TableInfo.EGG_D+ " TEXT "+
			") ";
	public static final  String CREATE_QUERY_BMR = "CREATE TABLE "+TableInfo.TABLE_NAME_BMR+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.AGE_BMR+ " TEXT, " +
			TableInfo.BODY_FAT+ " TEXT " +
			") ";
	public static final  String CREATE_QUERY_HEIGHT_WEIGHT = "CREATE TABLE "+TableInfo.TABLE_NAME_HEIGHT_WEIGHT+ "( " +
			_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TableInfo.HEIGHT_USER+ " TEXT, " +
			TableInfo.WEIGHT_USER+ " TEXT " +
			") ";
	
	public final static int database_version = 1;
	
	public DatabaseOperation(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Database Operations starts!!");		
	}

	@Override
	public void onCreate(SQLiteDatabase sq) {
		sq.execSQL(CREATE_QUERY);
		sq.execSQL(CREATE_QUERY_BREAKFAST);
		sq.execSQL(CREATE_QUERY_LUNCH);
		sq.execSQL(CREATE_QUERY_NOON);
		sq.execSQL(CREATE_QUERY_DINNER);
		sq.execSQL(CREATE_QUERY_BMR);
		sq.execSQL(CREATE_QUERY_HEIGHT_WEIGHT);
		
		//insert_item();

		String ROW1 = "INSERT INTO breakfast Values (1,'1000','60g/2piece','60g','1piece','30g','30g','enough','enough','90g','22g');";
		sq.execSQL(ROW1);
		String ROW2 = "INSERT INTO breakfast Values (2,'1200','60g/2piece','60g','1piece','30g','30g','enough','enough','90g','22g');";
		sq.execSQL(ROW2);
		String ROW3 = "INSERT INTO breakfast Values (3,'1400','60g/2piece','50g','1piece','30g','30g','enough','enough','70g','22g');";
		sq.execSQL(ROW3);
		String ROW4 = "INSERT INTO breakfast Values (4,'1600','90g/3piece','90g','1piece','30g','30g','enough','enough','90g','22g');";
		sq.execSQL(ROW4);
		String ROW5 = "INSERT INTO breakfast Values (5,'1800','120g/4piece','120g','1piece','30g','30g','enough','enough','120g','40g');";
		sq.execSQL(ROW5);
		String ROW6 = "INSERT INTO breakfast Values (6,'2000','120g/4piece','120g','1piece','30g','30g','enough','enough','120g','50g');";
		sq.execSQL(ROW6);
		String ROW7 = "INSERT INTO breakfast Values (7,'2200','120g/4piece','120g','1piece','30g','30g','enough','enough','120g','50g');";
		sq.execSQL(ROW7);
		String ROW8 = "INSERT INTO breakfast Values (8,'2400','150g/5piece','150g','1piece','30g','30g','enough','enough','130g','50g');";
		sq.execSQL(ROW8);
		String ROW9 = "INSERT INTO breakfast Values (9,'2600','150g/5piece','150g','1piece','60g','60g','enough','enough','130g','50g');";
		sq.execSQL(ROW9);
		String ROW10="INSERT INTO breakfast Values (10,'2800','150g/5piece','150g','1piece','60g','60g','enough','enough','130g','50g');";
		sq.execSQL(ROW10);
		
		//LUNCH
		String RO8="INSERT INTO lunch Values (1,'1000','180g','30g/1pieces','30g','30g','15g','enough');";
		sq.execSQL(RO8);
		String RO9="INSERT INTO lunch Values (2,'1200','270g','30g/1pieces','30g','30g','15g','enough');";
		sq.execSQL(RO9);
		String RO10="INSERT INTO lunch Values (3,'1400','300g','30g/1pieces','30g','30g','30g','enough');";
		sq.execSQL(RO10);
		String RO1="INSERT INTO lunch Values (4,'1600','300g','60g/2pieces','60g','60g','30g','enough');";
		sq.execSQL(RO1);
		String RO2="INSERT INTO lunch Values (5,'1800','360g','60g/2pieces','60g','60g','25g','enough');";
		sq.execSQL(RO2);
		String RO3="INSERT INTO lunch Values (6,'2000','400g','60g/2pieces','60g','60g','30g','enough');";
		sq.execSQL(RO3);
		String RO4="INSERT INTO lunch Values (7,'2200','450g','60g/2pieces','60g','60g','45g','enough');";
		sq.execSQL(RO4);
		String RO5="INSERT INTO lunch Values (8,'2400','500g','60g/2pieces','60g','60g','45g','enough');";
		sq.execSQL(RO5);
		String RO6="INSERT INTO lunch Values (9,'2600','540g','60g/2pieces','60g','60g','55g','enough');";
		sq.execSQL(RO6);
		String RO7="INSERT INTO lunch Values (10,'2800','540g','60g/2pieces','60g','60g','55g','enough');";
		sq.execSQL(RO7);
		
		
		//afterNOON
		String RW1="INSERT INTO afternoon Values (1,'1000','120ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW1);
		String RW2="INSERT INTO afternoon Values (2,'1200','120ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW2);
		String RW3="INSERT INTO afternoon Values (3,'1400','60ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW3);		
		String RW4="INSERT INTO afternoon Values (4,'1600','120ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW4);
		String RW5="INSERT INTO afternoon Values (5,'1800','60ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW5);
		String RW6="INSERT INTO afternoon Values (6,'2000','120ml','30g','30g','25g','22g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW6);
		String RW7="INSERT INTO afternoon Values (7,'2200','250ml','60g','60g','50g','45g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW7);
		String RW8="INSERT INTO afternoon Values (8,'2400','250ml','60g','60g','50g','45g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW8);
		String RW9="INSERT INTO afternoon Values (9,'2600','250ml','60g','60g','50g','45g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW9);
		String RW10="INSERT INTO afternoon Values (10,'2800','250ml','60g','60g','50g','45g','60g papaya','40g guava','30g mango','60g orange','50g malta','150g water melon','40g grapes','25g banana','40g apple');";
		sq.execSQL(RW10);
		
		//dinner
		String WK1="INSERT INTO dinner Values (1,'1000','60g','30g/1piece','30g','15g','enough','1piece');";
		sq.execSQL(WK1);	
		String WK2="INSERT INTO dinner Values (2,'1200','60g','30g/1piece','30g','15g','enough','half piece');";
		sq.execSQL(WK2);
		String WK3="INSERT INTO dinner Values (3,'1400','90g','30g/1piece','30g','15g','enough','half piece');";
		sq.execSQL(WK3);	
		String WK4="INSERT INTO dinner Values (4,'1600','120g','30g/1piece','30g','15g','enough','half piece');";
		sq.execSQL(WK4);
		String WK5="INSERT INTO dinner Values (5,'1800','120g','30g/1piece','30g','25g','enough','half piece');";
		sq.execSQL(WK5);
		String WK6="INSERT INTO dinner Values (6,'2000','150g','30g/1piece','30g','30g','enough','1piece');";
		sq.execSQL(WK6);
		String WK7="INSERT INTO dinner Values (7,'2200','150g','30g/1piece','30g','30g','enough','1piece');";
		sq.execSQL(WK7);
		String WK8="INSERT INTO dinner Values (8,'2400','150g','30g/1piece','30g','30g','enough','1piece');";
		sq.execSQL(WK8);
		String WK9="INSERT INTO dinner Values (9,'2600','150g','60g/1piece','60g','45g','enough','1piece');";
		sq.execSQL(WK9);
		String WK10="INSERT INTO dinner Values (10,'2800','180g','60g/1piece','60g','45g','enough','1piece');";
		sq.execSQL(WK10);
		
		//bmrtable
        String R2="INSERT INTO bmrtable Values(1,31,4.6);";
        sq.execSQL(R2); 	
        String R3="INSERT INTO bmrtable Values(2,32,4.9);";
        sq.execSQL(R3); 	
        String R4="INSERT INTO bmrtable Values(3,33,5.1);";
        sq.execSQL(R4); 	
        String R5="INSERT INTO bmrtable Values(4,34,5.2);";
        sq.execSQL(R5); 	
        String R6="INSERT INTO bmrtable Values(5,35,5.5);";
        sq.execSQL(R6); 	
        String R7="INSERT INTO bmrtable Values(6,36,5.6);";
        sq.execSQL(R7); 	
        String R8="INSERT INTO bmrtable Values(7,37,5.7);";
        sq.execSQL(R8); 	
        String R9="INSERT INTO bmrtable Values(8,38,5.8);";
        sq.execSQL(R9); 	
        String R10="INSERT INTO bmrtable Values(9,39,5.9);";
        sq.execSQL(R10); 	
        String R11="INSERT INTO bmrtable Values(10,40,11.5);";
        sq.execSQL(R11); 	
        String R12="INSERT INTO bmrtable Values(11,41,11.5);";
        sq.execSQL(R12); 	
        String R13="INSERT INTO bmrtable Values(12,42,11.6);";
        sq.execSQL(R13); 	
        String R14="INSERT INTO bmrtable Values(13,43,11.9);";
        sq.execSQL(R14); 	
        String R15="INSERT INTO bmrtable Values(14,44,12.5);";
        sq.execSQL(R15); 	
        String R16="INSERT INTO bmrtable Values(15,45,12.6);";
        sq.execSQL(R16); 	
        String R17="INSERT INTO bmrtable Values(16,46,12.7);";
        sq.execSQL(R17); 	
        String R18="INSERT INTO bmrtable Values(17,47,12.8);";
        sq.execSQL(R18); 	
        String R19="INSERT INTO bmrtable Values(18,48,13.2);";
        sq.execSQL(R19); 	
        String R20="INSERT INTO bmrtable Values(19,49,13.5);";
        sq.execSQL(R20);
        String R21="INSERT INTO bmrtable Values(20,50,13.6);";
        sq.execSQL(R21); 	
        String R22="INSERT INTO bmrtable Values(21,51,13.7);";
        sq.execSQL(R22);
        String R23="INSERT INTO bmrtable Values(22,52,13.9);";
        sq.execSQL(R23);
        String R24="INSERT INTO bmrtable Values(23,53,14.2);";
        sq.execSQL(R24);
        String R25="INSERT INTO bmrtable Values(24,54,14.5);";
        sq.execSQL(R25);
        String R26="INSERT INTO bmrtable Values(25,55,14.7);";
        sq.execSQL(R26);
        String R27="INSERT INTO bmrtable Values(26,56,14.8);";
        sq.execSQL(R27);
        
        //weight_height table
        String a1 = "INSERT INTO ideal_unit Values(1,136,35);";
        sq.execSQL(a1);
        String a2 = "INSERT INTO ideal_unit Values(2,138,39);";
        sq.execSQL(a2);
        String a3 = "INSERT INTO ideal_unit Values(3,140,40);";
        sq.execSQL(a3);
        String a4 = "INSERT INTO ideal_unit Values(4,142,44);";
        sq.execSQL(a4);
        String a5 = "INSERT INTO ideal_unit Values(5,144,46);";
        sq.execSQL(a5);
        String a6 = "INSERT INTO ideal_unit Values(6,146,50);";
        sq.execSQL(a6);
        String a7 = "INSERT INTO ideal_unit Values(7,148,53);";
        sq.execSQL(a7);
        String a8 = "INSERT INTO ideal_unit Values(8,150,55);";
        sq.execSQL(a8);
        String a9 = "INSERT INTO ideal_unit Values(9,152,59);";
        sq.execSQL(a9);
        String a10 = "INSERT INTO ideal_unit Values(10,154,61);";
        sq.execSQL(a10);
        String a11 = "INSERT INTO ideal_unit Values(11,156,65);";
        sq.execSQL(a11);
        String a12 = "INSERT INTO ideal_unit Values(12,158,67);";
        sq.execSQL(a12);
        String a13 = "INSERT INTO ideal_unit Values(13,160,79);";
        sq.execSQL(a13);
        String a14 = "INSERT INTO ideal_unit Values(14,162,72);";
        sq.execSQL(a14);
        String a15 = "INSERT INTO ideal_unit Values(15,164,73);";
        sq.execSQL(a15);
        String a16 = "INSERT INTO ideal_unit Values(16,166,74);";
        sq.execSQL(a16);
        String a17 = "INSERT INTO ideal_unit Values(17,168,75);";
        sq.execSQL(a17);
        String a18 = "INSERT INTO ideal_unit Values(18,170,76);";
        sq.execSQL(a18);
        String a19 = "INSERT INTO ideal_unit Values(19,172,80);";
        sq.execSQL(a19);
        String a20 = "INSERT INTO ideal_unit Values(20,174,83);";
        sq.execSQL(a20);
        String a21 = "INSERT INTO ideal_unit Values(21,176,85);";
        sq.execSQL(a21);
        String a22 = "INSERT INTO ideal_unit Values(22,178,85);";
        sq.execSQL(a22);
        String a23 = "INSERT INTO ideal_unit Values(23,180,89);";
        sq.execSQL(a23);
        String a24 = "INSERT INTO ideal_unit Values(24,182,90);";
        sq.execSQL(a24);
        String a25 = "INSERT INTO ideal_unit Values(25,184,90);";
        sq.execSQL(a25);
		
        
        Log.d("Database Operations", "Database Created!!");
	}


	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {}
	
	public void putInformation(DatabaseOperation dop, String nam, String val, String uni, String uag, String uwgt, String uhgt){
		SQLiteDatabase sq = getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		cv.put(TableInfo.USER_NAME, nam);
		cv.put(TableInfo.SUGAR_LEVEL, val);
		cv.put(TableInfo.UNIT, uni);
		cv.put(TableInfo.AGE, uag);
		cv.put(TableInfo.WEIGHT, uwgt);
		cv.put(TableInfo.HEIGHT, uhgt);
		
		sq.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database insertion", "one raw inserted");
	}
	
	public void insert_item() {
		SQLiteDatabase sq = getWritableDatabase();
		String ROW1 = "INSERT INTO breakfast Values (1,'1000','60g','60g','1piece','15g','15g','enough','enough','90g','22g');";
	    sq.execSQL(ROW1);
		
	}
	
	public Cursor getInformation(DatabaseOperation dop){
		String[] columns = {TableInfo.USER_NAME,TableInfo.SUGAR_LEVEL,TableInfo.UNIT,TableInfo.AGE,TableInfo.WEIGHT};		
		
		SQLiteDatabase sq = getReadableDatabase();
		Cursor CR = sq.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
		return CR;
	}
	
		
	public Cursor getdetails(DatabaseOperation dop, String rdata, String pos_id){
		SQLiteDatabase sq = dop.getReadableDatabase();
		String[] columns = {TableInfo._ID,TableInfo.USER_NAME,TableInfo.SUGAR_LEVEL,TableInfo.UNIT,TableInfo.AGE,TableInfo.WEIGHT,TableInfo.HEIGHT};
		Cursor CR = sq.query(TableInfo.TABLE_NAME, columns, "username=? and _id=?", new String[]{rdata,pos_id}, null, null, null);
		return CR;
	}
	
	public Cursor getdetailsUser(DatabaseOperation dop, String rdata){
		SQLiteDatabase sq = dop.getReadableDatabase();
		String[] columns = {TableInfo._ID,TableInfo.USER_NAME,TableInfo.SUGAR_LEVEL,TableInfo.UNIT,TableInfo.AGE,TableInfo.WEIGHT,TableInfo.HEIGHT};
		Cursor CR = sq.query(TableInfo.TABLE_NAME, columns, "_id=?", new String[]{rdata}, null, null, null);
		return CR;
	}
		
	public void updateInformation(DatabaseOperation dop, String user_name, String us_id, String update_value, String level_unit,String age, String wght, String hght){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		cv.put(TableInfo.SUGAR_LEVEL, update_value);
		cv.put(TableInfo.UNIT, level_unit);
		cv.put(TableInfo.AGE, age);
		cv.put(TableInfo.WEIGHT, wght);
		cv.put(TableInfo.HEIGHT, hght);
		Log.d(update_value, "update_value");
		Log.d(level_unit, "level_unit");

	    sq.update(TableInfo.TABLE_NAME, cv, "username=? and _id=?", new String[]{user_name,us_id});
	}
	
	public Cursor getitemdetails(DatabaseOperation dop, String category, String nam, String calori){
		SQLiteDatabase sq = dop.getReadableDatabase();
		String[] columns = {nam};
		Cursor CR = sq.query(category, columns, "calorie=?", new String[]{calori}, null, null, null);
		return CR;
	}
	
	public Cursor getbodyfat(DatabaseOperation dop,String age){
		SQLiteDatabase sq = dop.getReadableDatabase();
		String[] columns = {TableInfo.BODY_FAT};
		Cursor CR = sq.query(TableInfo.TABLE_NAME_BMR, columns, "age=?", new String[]{age}, null, null, null);
		return CR;
	}
	
	public Cursor getidealvalue(DatabaseOperation dop,String height){
		SQLiteDatabase sq = dop.getReadableDatabase();
		String[] columns = {TableInfo.WEIGHT_USER};
		Cursor CR = sq.query(TableInfo.TABLE_NAME_HEIGHT_WEIGHT, columns, "height=?", new String[]{height}, null, null, null);
		return CR;
	}

}
