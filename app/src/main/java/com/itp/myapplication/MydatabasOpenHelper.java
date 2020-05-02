package com.itp.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;



public class MydatabasOpenHelper extends SQLiteOpenHelper {



    public MydatabasOpenHelper(@Nullable Context context) {
        super(context,"TodosVt", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Todos` (\n" +
                "\t`todo_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`todo_icerik`\tTEXT,\n" +
                "\t`todo_complete`\tINTEGER NOT NULL,\n" +
                "\t`todo_whenCreated`\tINTEGER NOT NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  'Todos'");
        onCreate(db);
    }

    public final class FeedEntry implements BaseColumns {
            public static final String Table_Name="Todos";
        public static final String COLUMN_NAME_TITLE="";
    }
}
