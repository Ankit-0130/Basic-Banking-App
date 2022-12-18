package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Shreyash Supe', 'shreyash@gmail.com','7565','987654323', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Hardik Chaudhari', 'hardik@gmail.com','0987','8976565467', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Saurabh Chaware', 'saurabh@gmail.com','3456','9034256834', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'harshal Pawar', 'harshal@gmail.com','2345','9846276453', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivam Narkhede', 'shivam@gmail.com','9876','9846536763', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Prasad Mane', 'prasad@gmail.com','7564','8855640238', 60500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Vishal Bhure', 'vishal@gmail.com','1462','8895640215', 14500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Abhijeet Bhingole', 'abhijeet@gmail.com','8546','9985021539', 12500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rohan ', 'rohan@gmail.com','4653','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ganesh Anerao', 'ganesh@gmail.com','7236','8292591201', 9950)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Pratik Patil', 'Pratik@gmail.com','6475','9015641200', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Shubham Karoshi', 'shubham@gmail.com','1209','9995641999', 11500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Apoorv Varkute', 'apoorv@gmail.com','9045','9119541001', 5400)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Ashwin Ghute', 'ashwin@gmail.com','9767','6254642205', 5300)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Mihir Jawale', 'mihir@gmail.com','1770','6893641266', 2100)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}