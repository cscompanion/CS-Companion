package com.itp.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.itp.myapplication.MydatabasOpenHelper;
import com.itp.myapplication.TodosDao;
import com.itp.myapplication.AddTodoDialog;
import com.itp.myapplication.MyRecyAdapter;
import com.itp.myapplication.Todos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {
    public static RecyclerView RECYCLER_VİEW;
    private static ArrayList<Todos> todos;
    public static MyRecyAdapter MYRC_ADAPTER;
    private Calendar date;
    private static TodosDao todosDao;
    private static MydatabasOpenHelper mydatabasOpenHelper;

    private FloatingActionButton fab;

    public static FragmentManager FRAGMENT_MANAGER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FRAGMENT_MANAGER=getSupportFragmentManager();
        date=new GregorianCalendar();

        RECYCLER_VİEW =findViewById(R.id.RcView);
        fab=findViewById(R.id.fab);

        RECYCLER_VİEW.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        RECYCLER_VİEW.setLayoutManager(layoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTodoDialog addTodoDialog=new AddTodoDialog(getApplicationContext());
                addTodoDialog.show(getSupportFragmentManager().beginTransaction(),"addDialog");

            }
        });

        mydatabasOpenHelper=new MydatabasOpenHelper(this);
        todosDao=new TodosDao();


        todos=todosDao.todosget(mydatabasOpenHelper);

        MYRC_ADAPTER=new MyRecyAdapter(this,todos);
        RECYCLER_VİEW.setAdapter(MYRC_ADAPTER);






    }
    public static void updateGUI(){
        todos=todosDao.todosget(mydatabasOpenHelper);
        MYRC_ADAPTER.refreshData(todos);

        MYRC_ADAPTER.notifyDataSetChanged();

    }
}
