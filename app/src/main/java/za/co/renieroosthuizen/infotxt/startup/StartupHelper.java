package za.co.renieroosthuizen.infotxt.startup;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Renier on 2015/06/23.
 */
public class StartupHelper {

    public static void createTables(SQLiteDatabase db)
    {
        String sql;

        sql = " CREATE TABLE IF NOT EXISTS InfoItem ( " +
                " GUID TEXT PRIMARY KEY, " +
                " InfoItemName TEXT " +
                " ) ";
        db.execSQL(sql);

        sql = " CREATE TABLE IF NOT EXISTS InfoItemPart ( " +
                " GUID TEXT PRIMARY KEY, " +
                " ItemGUID TEXT " +
                " PartType INTEGER " +
                " PartName TEXT " +
                " ) ";
        db.execSQL(sql);

        sql = " CREATE TABLE IF NOT EXISTS InfoItemPartParameter ( " +
                " GUID TEXT PRIMARY KEY, " +
                " PartGUID TEXT " +
                " ParameterKey TEXT " +
                " ParameterValue TEXT " +
                " ) ";
        db.execSQL(sql);
    }

    public static void populateInitialValues(SQLiteDatabase db)
    {

    }
}
