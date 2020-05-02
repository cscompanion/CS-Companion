package com.itp.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddTodoDialog extends DialogFragment {
    private Context mContext;
    private TodosDao todosDao;
    private MydatabasOpenHelper mydatabasOpenHelper;
    private Calendar date;




    public AddTodoDialog(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        date=new GregorianCalendar();
        mydatabasOpenHelper=new MydatabasOpenHelper(getContext());
        todosDao=new TodosDao();





        LayoutInflater layoutInflater=requireActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.addtodo_dialog,null,false);

        final EditText editText_icerik=view.findViewById(R.id.icerik_editext);
        final CheckBox checkBox_isCompleted=view.findViewById(R.id.checkboxİsChecked);

        TextView textView_whenCreate=view.findViewById(R.id.create_time);

        textView_whenCreate.setText(String.valueOf(date.getTime()));


        AlertDialog.Builder  builder=new AlertDialog.Builder(getActivity());


                    builder.setTitle("Add todo")
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //veri vt ye eklendi
                            todosDao.insertTodo(mydatabasOpenHelper,editText_icerik.getText().toString(),checkBox_isCompleted.isChecked(),String.valueOf(date.getTime()));
                            MainActivity.updateGUI();


                        }
                    })

                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.e("alert","negative button");
                        }
                    });

            builder.setView(view);

            return builder.create();

    }
}
