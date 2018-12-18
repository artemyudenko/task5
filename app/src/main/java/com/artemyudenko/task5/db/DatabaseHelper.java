package com.artemyudenko.task5.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.artemyudenko.task5.db.DBEnum.ISIN_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.DB_NAME;
import static com.artemyudenko.task5.db.DBEnum.ID_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.NAME_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.DESCRIPTION_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.BRANCH_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.TABLE_NAME;

class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DB_NAME.getS(), null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME.getS() + " ("
                + ID_COLUMN.getS() + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN.getS() + " TEXT, "
                + DESCRIPTION_COLUMN.getS() + " TEXT, "
                + BRANCH_COLUMN.getS() + " INTEGER, "
                + ISIN_COLUMN.getS() + " INTEGER default 0"
                + ");";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME.getS());
        onCreate(db);
    }
}
