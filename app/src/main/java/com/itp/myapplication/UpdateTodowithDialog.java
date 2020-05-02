package com.itp.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.itp.myapplication.MydatabasOpenHelper;
import com.itp.myapplication.TodosDao;
import com.itp.myapplication.MainActivity;
import com.itp.myapplication.R;

public class UpdateTodowithDialog extends DialogFragment {

    private Context mContext;
    private TodosDao todosDao;
    private MydatabasOpenHelper mydatabasOpenHelper;


    //dialog ile yapılacak güncelleme icin gerekli alanlar
    private boolean checkBoxIschecked;
    private String icerik;
    private String date;
    private int todoId;

  public   UpdateTodowithDialog(Context mContext) {
        this.mContext = mContext;
    }

    public UpdateTodowithDialog(Context mContext, boolean checkBoxIschecked, String icerik,String date,int todoId){
        this.mContext=mContext;
        this.checkBoxIschecked=checkBoxIschecked;
        this.icerik=icerik;
        this.date=date;
        this.todoId=todoId;


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        mydatabasOpenHelper=new MydatabasOpenHelper(getContext());
        todosDao=new TodosDao();

        LayoutInflater layoutInflater=requireActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.update_todo_dialog,null,false);

        final EditText editTextIcerik =view.findViewById(R.id.icerik_editext);
        final CheckBox checkBoxİschecked=view.findViewById(R.id.checkboxİsChecked);
        final TextView textViewTarih=view.findViewById(R.id.create_timeforUpdate);

        //icersinde zaten var olan verilerin viewe yerleştirilmesi
        editTextIcerik.setText(icerik);
        checkBoxİschecked.setChecked(checkBoxIschecked);
        textViewTarih.setText(date);

        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
            builder.setTitle("Update todo")
                    .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           todosDao.updateTodo(mydatabasOpenHelper,todoId,String.valueOf(editTextIcerik.getText())
                                   ,checkBoxİschecked.isChecked(),
                                   String.valueOf(textViewTarih.getText()));
                            MainActivity.updateGUI();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.setView(view);


        return builder.create();
    }
}
