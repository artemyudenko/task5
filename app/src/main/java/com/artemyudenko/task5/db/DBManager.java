package com.artemyudenko.task5.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.artemyudenko.task5.model.Shop;

import static com.artemyudenko.task5.db.DBEnum.BRANCH_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.DESCRIPTION_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.ID_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.ISIN_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.NAME_COLUMN;
import static com.artemyudenko.task5.db.DBEnum.TABLE_NAME;
import static com.artemyudenko.task5.db.DBEnum.getColumnNamesArray;

public class DBManager {
    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        this.context = c;
    }

    public DBManager open() {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        databaseHelper.close();
    }

    public void insert(Shop shop) {
        ContentValues contentValues = constructDBObject(shop);
        database.insert(TABLE_NAME.getS(), null, contentValues);
    }

    public Cursor fetch() {
        Cursor cursor = database.query(TABLE_NAME.getS(), getColumnNamesArray(), null, null, null, null, NAME_COLUMN.getS());
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(Shop item, long id) {
        ContentValues contentValues = constructDBObject(item);
        return database.update(TABLE_NAME.getS(), contentValues, ID_COLUMN.getS() + '=' + id, null);
    }

    public void delete(long id) {
        database.delete(TABLE_NAME.getS(), ID_COLUMN.getS() + '=' + id, null);
    }


    private ContentValues constructDBObject(Shop item) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(NAME_COLUMN.getS(), item.getName());
        contentValue.put(DESCRIPTION_COLUMN.getS(), item.getDescription());
        contentValue.put(BRANCH_COLUMN.getS(), item.getBranch());
        contentValue.put(ISIN_COLUMN.getS(), item.isIn());
        return contentValue;
    }
}
