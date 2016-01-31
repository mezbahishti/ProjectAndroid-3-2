package com.sazid.mealsplan;

import android.provider.BaseColumns;

public class TableData {

	public TableData(){}
	
	public static abstract class TableInfo implements BaseColumns{
		
		public final static String USER_NAME = "username";
		public final static String SUGAR_LEVEL = "sugarlevel";
		public final static String UNIT = "unit";
		public final static String AGE = "age";
		public final static String WEIGHT = "weight";
		public final static String HEIGHT = "height";
		
		public final static String CALORIE_B = "calorie";
		public final static String RICE_B = "rice";
		public final static String BREAD_B = "bread";
		public final static String EGG_B = "egg";
		public final static String BREAD_ROLL_B = "bread_roll";
		public final static String PUFFED_RICE_B = "puffed";
		public final static String BISCUIT_B = "salt";
		public final static String VEGETABLES_B = "vegetables";
		public final static String FRUITS_B = "fruits";
		public final static String POTATO_B = "potato";
		public final static String CORN_B = "corn";
		
		
		public final static String CALORIE_L = "calorie";
		public final static String RICE_L = "rice";
		public final static String FISH_L = "fish";
		public final static String CHICKEN_L = "chicken";
		public final static String BEEF_L = "beef";
		public final static String PEAS_L = "peas";
		public final static String VEGETABLES_L = "vegetables";
		
		public final static String CALORIE_N = "calorie";
		public final static String MILK_N = "milk";
		public final static String PEANUT_N = "peanut";
		public final static String PEAS_N = "peas";
		public final static String CHICKPEA_N = "chickpea";
		public final static String NODDLES_N = "noddles";
				
		public final static String CALORIE_D = "calorie";
		public final static String BREAD_D = "bread";
		public final static String FISH_D = "fish";
		public final static String MEAT_D = "meat";
		public final static String PEAS_D = "peas";
		public final static String VEGETABLES_D = "vegetables";
		public final static String EGG_D = "egg";
		
		public final static String PAPAYA = "papaya";
		public final static String GUAVA = "guava";
		public final static String MANGO = "mango";
		public final static String ORANGE = "orange";
		public final static String MALTA = "malta";
		public final static String WATER_MELON = "watermelon";
		public final static String GRAPES = "grape";
		public final static String BANANA = "banana";
		public final static String APPLE = "apple";
		
		public final static String AGE_BMR = "age";
		public final static String BODY_FAT = "bodyfat";
		
		public final static String HEIGHT_USER = "height";
		public final static String WEIGHT_USER = "weight";
		
		public final static String DATABASE_NAME = "meal_plan";
		public final static String TABLE_NAME = "user_table";
		public final static String TABLE_NAME_BREAKFAST = "breakfast";
		public final static String TABLE_NAME_LUNCH = "lunch";
		public final static String TABLE_NAME_NOON = "afternoon";
		public final static String TABLE_NAME_DINNER = "dinner";
		public final static String TABLE_NAME_BMR = "bmrtable";
		public final static String TABLE_NAME_HEIGHT_WEIGHT = "ideal_unit";
		
	}
	
}
