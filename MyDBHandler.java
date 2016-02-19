package mikemeat.admin.moodtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import java.sql.Date;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "scoreDB.db";
    public static final String TABLE_SCORES = "scores";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SCORE = "scores";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_CAUSE = "cause";
    public static final String COLUMN_DATE = "date";

     //We need to pass database information along to superclass
     public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_SCORES + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        COLUMN_DATE + " TEXT, " +
        COLUMN_SCORE + " TEXT ," +
        COLUMN_CATEGORY + " TEXT, " +
        COLUMN_CAUSE + " TEXT " +
         ");";
        db.execSQL(query);
        }

     @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
         onCreate(db);
        }


//    public boolean addScores  (String scores, String category, String cause, String datetime)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("scores", scores);
//        contentValues.put("category", category);
//        contentValues.put("cause", cause);
//        db.insert("scores", null, contentValues);
//        db.close();
//        return true;
//    }



    //Add a new row to the database
    public void addScores(scores scores){
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, scores.get_scores());
        values.put(COLUMN_CAUSE, scores.get_cause());
        values.put(COLUMN_CATEGORY, scores.get_category());
        values.put(COLUMN_DATE, scores.get_date());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SCORES, null, values);
        db.close();
    }


     //Delete a product from the database

     public void deleteScores(String datetime){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SCORES + " WHERE " + COLUMN_DATE + "=\"" + datetime + "\";");
         }

     public String databaseToString(){
         String dbString = "";
         SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SCORES + " WHERE _ID = (SELECT MAX(_ID) FROM " + TABLE_SCORES + ");";

        //Cursor points to a location in your results
         Cursor c = db.rawQuery(query, null);
         //Move to the first row in your results
         c.moveToFirst();

         //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
             if (c.getString(c.getColumnIndex("scores")) != null) {
                 dbString += c.getString(c.getColumnIndex("scores"));
                 dbString += c.getString(c.getColumnIndex("cause"));
                 dbString += c.getString(c.getColumnIndex("category"));
                 dbString += c.getString(c.getColumnIndex("date"));
                 dbString += "\n";
                 }
             c.moveToNext();
             }
         db.close();
         return dbString;
        }



}