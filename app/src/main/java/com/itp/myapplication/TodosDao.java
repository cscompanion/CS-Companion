package com.itp.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itp.myapplication.Todos;

import java.util.ArrayList;

public class TodosDao {
    private ArrayList<Todos> todos;

    public void insertTodo(MydatabasOpenHelper mydatabasOpenHelper, String todoİcerik, boolean todoComplete, String whenCreated){

        SQLiteDatabase db=mydatabasOpenHelper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("todo_icerik",todoİcerik);
        contentValues.put("todo_complete",todoComplete);
        contentValues.put("todo_whenCreated",whenCreated);

        db.insertOrThrow("Todos",null,contentValues);
        db.close();

    }
    public ArrayList<Todos> todosget(MydatabasOpenHelper mydatabasOpenHelper){
        todos=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=mydatabasOpenHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM Todos",null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("todo_id"));
            String icerik=cursor.getString(cursor.getColumnIndex("todo_icerik"));
            //convert to boolen
            boolean complete;
            if(cursor.getInt(cursor.getColumnIndex("todo_complete"))==0){
                complete=false;
            }else {
                complete=true;
            }
                   String whencreated=cursor.getString(cursor.getColumnIndex("todo_whenCreated"));
            Todos todo = new Todos(id,icerik,complete,whencreated);

                todos.add(todo);
        }
        return todos;
    }
    public void updateTodo(MydatabasOpenHelper vt,int id,String todoİcerik, boolean todoComplete, String whenCreated){

        SQLiteDatabase db=vt.getWritableDatabase();


        ContentValues contentValues=new ContentValues();
        contentValues.put("todo_icerik",todoİcerik);
        contentValues.put("todo_complete",todoComplete);
        contentValues.put("todo_whenCreated",whenCreated);

        db.update("Todos",contentValues,"todo_id=?",new String[]{String.valueOf(id)});

        db.close();

    }
    public void deleteTodo(MydatabasOpenHelper mydatabasOpenHelper,int id){
        SQLiteDatabase db=mydatabasOpenHelper.getWritableDatabase();
        db.delete("Todos","todo_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

}
