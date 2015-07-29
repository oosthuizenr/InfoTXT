package za.co.renieroosthuizen.infotxt.database;


import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;

import java.sql.SQLException;

import za.co.renieroosthuizen.infotxt.startup.StartupHelper;

public class Database {
	
	public static final String DATABASE_NAME = "InfoTXT.db";
	public static final int DATABASE_VERSION = 1;
	
	private static Database instance;
	public static synchronized Database getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new Database(context);
			instance.openToWrite();
		}
		
		return instance;
	}

	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private Context context;

	private String _pathToDbFile;
	public String getPathToDbFile() {
		return _pathToDbFile;
	}

	public Database(Context c){
		context = c;
		_pathToDbFile = "";
	}

	public Context getContext()
	{
		return context;
	}


	public Database openToRead() throws android.database.SQLException {

		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();

		_pathToDbFile = sqLiteDatabase.getPath();

		return this;
	}
	
	public Database openToRead(String dbName, int dbVersion) throws android.database.SQLException {

		sqLiteHelper = new SQLiteHelper(context, dbName, null, dbVersion);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();

		_pathToDbFile = sqLiteDatabase.getPath();

		return this;
	}

	public Database openToWrite() throws android.database.SQLException {

		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();

		_pathToDbFile = sqLiteDatabase.getPath();

		return this;
	}

	public Database openToWrite(String dbName, int dbVersion) throws android.database.SQLException {

		sqLiteHelper = new SQLiteHelper(context, dbName, null, dbVersion);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();

		_pathToDbFile = sqLiteDatabase.getPath();

		return this;
	}

	public void close(){

		try {
			sqLiteHelper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized long insert (String table, String nullColumnHack, ContentValues values)
	{
		return sqLiteDatabase.insert(table, nullColumnHack, values);
	}

	public synchronized long insertOrThrow (String table, String nullColumnHack, ContentValues values) throws SQLException
	{
		return sqLiteDatabase.insertOrThrow(table, nullColumnHack, values);
	}

	public synchronized  long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm)
	{
		return sqLiteDatabase.insertWithOnConflict(table, nullColumnHack, initialValues, conflictAlgorithm);
	}

	public synchronized int delete(String table, String whereClause, String[] whereArgs)
	{
		return sqLiteDatabase.delete(table, whereClause, whereArgs);
	}

	public synchronized int update(String table, ContentValues values, String whereClause, String[] whereArgs)
	{
		return sqLiteDatabase.update(table, values, whereClause, whereArgs);
	}

	public synchronized int updateWithOnConflict(String table, ContentValues values, String whereClause, String[] whereArgs, int conflictAlgorithm)
	{
		return sqLiteDatabase.updateWithOnConflict(table, values, whereClause, whereArgs, conflictAlgorithm);
	}

	public Cursor query (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
	{
		return sqLiteDatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public Cursor query (boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit, CancellationSignal cancellationSignal) {
		return sqLiteDatabase.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal);
	}

	public Cursor query (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
	{
		return sqLiteDatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	}

	public Cursor query (boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
	{
		return sqLiteDatabase.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public Cursor queryWithFactory (SQLiteDatabase.CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit, CancellationSignal cancellationSignal)
	{
		return sqLiteDatabase.queryWithFactory(cursorFactory, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal);
	}

	public Cursor queryWithFactory (SQLiteDatabase.CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
	{
		return sqLiteDatabase.queryWithFactory(cursorFactory, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
	}

	public void beginTransaction()
	{
		sqLiteDatabase.beginTransaction();
	}

	public void beginTransactionNonExclusive()
	{
		sqLiteDatabase.beginTransactionNonExclusive();
	}

	public void beginTransactionWithListener(SQLiteTransactionListener transactionListener)
	{
		sqLiteDatabase.beginTransactionWithListener(transactionListener);
	}

	public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener)
	{
		sqLiteDatabase.beginTransactionWithListenerNonExclusive(transactionListener);
	}

	public void endTransaction()
	{
		sqLiteDatabase.endTransaction();
	}

	public boolean inTransaction()
	{
		return sqLiteDatabase.inTransaction();
	}

	public void setTransactionSuccessful()
	{
		sqLiteDatabase.setTransactionSuccessful();
	}



	public static void closeCursor(Cursor cursor)
	{
		try
		{
			cursor.close();
		}
		catch(Exception e)
		{
			//cursor null or some other exception
		}
		cursor = null;
	}

	public static boolean isCursorEmpty(Cursor c)
	{
		if (c != null)
		{
			if (c.getCount() > 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
	

	public class SQLiteHelper extends SQLiteOpenHelper {

		public SQLiteHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			StartupHelper.createTables(db);
			StartupHelper.populateInitialValues(db);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

}