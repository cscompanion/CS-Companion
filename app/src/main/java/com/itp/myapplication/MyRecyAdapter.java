package com.itp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.CardTasarimTutucu>  {
    private Context mContext;
    private List<Todos> todos;

    private TodosDao todosDao;
    private MydatabasOpenHelper mydatabasOpenHelper;


    private Calendar date;


    public MyRecyAdapter(Context mContext, List<Todos> todos) {
        this.mContext = mContext;
        this.todos = todos;
        date=new GregorianCalendar();
        mydatabasOpenHelper=new MydatabasOpenHelper(mContext);
        todosDao=new TodosDao();
    }

    public void refreshData(List<Todos> todos){
        this.todos=todos;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,null);
        return new CardTasarimTutucu(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu holder, final int position) {
        holder.checkBox.setChecked(todos.get(position).isTodoComplete());
        holder.textViewIcerik.setText(todos.get(position).getTodoIcerik());

        Log.e("nesne",todos.get(position).getWhenCreated());
        holder.imageViewDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todosDao.deleteTodo(mydatabasOpenHelper,todos.get(position).getTodoId());
                MainActivity.updateGUI();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String icerik= (String) holder.textViewIcerik.getText();
                boolean ischecked=holder.checkBox.isChecked();

                UpdateTodowithDialog updateTodowithDialog=new UpdateTodowithDialog(mContext,ischecked,icerik,todos.get(position).getWhenCreated(),todos.get(position).getTodoId());
                Activity activity= (Activity) mContext;

                updateTodowithDialog.show(MainActivity.FRAGMENT_MANAGER,"updatedeTodo");
            }
        });


    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class  CardTasarimTutucu extends RecyclerView.ViewHolder{
       public CheckBox checkBox;
        public TextView textViewIcerik,textViewDate;
       public CardView cardView;
       public ImageView imageViewDeleteItem;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkBoxTodo);
            cardView=itemView.findViewById(R.id.cardView);
            textViewIcerik=itemView.findViewById(R.id.ticerikText);
            imageViewDeleteItem=itemView.findViewById(R.id.imageView);




        }

    }

}
