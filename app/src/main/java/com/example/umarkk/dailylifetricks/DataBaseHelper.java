package com.example.umarkk.dailylifetricks;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lifehacksDB";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    String DB_Path = null;


    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        this.DB_Path = "/data/data/" + context.getPackageName() + "/" + "databases/";

    }

    //Create a empty database on the system
    public void createDatabase() throws IOException
    {

        boolean dbExist = checkDataBase();

        if(dbExist)
        {
            Log.v("DB Exists", "db exists");
            // By calling this method here onUpgrade will be called on a
            // writeable database, but only if the version number has been
            // bumped
            //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);

        }else {

            this.getReadableDatabase();
            try {
                copyDataBase();
            }catch (IOException e){
                throw new Error("Error Copying Database");
            }
        }

    }

    //Check database already exist or not
    private boolean checkDataBase()
    {
        SQLiteDatabase checkDB = null;
        try
        {
            String myPath = DB_Path + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch(SQLiteException e)
        {
        }
        if (checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }


    //Copies your database from your local assets-folder to the just created empty database in the system folder
    private void copyDataBase() throws IOException
    {

        InputStream mInput = myContext.getAssets().open(DATABASE_NAME);
        String outFileName = DB_Path + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);

        byte[] mBuffer = new byte[10];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }


    //Open database
    public void openDatabase() throws SQLException
    {
        String myPath = DB_Path + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }



    public synchronized void closeDataBase()throws SQLException
    {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i1 > i)
            try{
                copyDataBase();
            }catch (IOException e){
                e.printStackTrace();
            }
    }


    public Cursor query(String table, String[] columns,String selection, String[] selectionargs,
                        String groupby, String having,String orderby) {

        return myDataBase.query("lifehacks", null, null, null, null, null, null);
    }

}
