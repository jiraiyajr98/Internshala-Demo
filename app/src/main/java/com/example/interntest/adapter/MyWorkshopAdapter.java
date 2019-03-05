package com.example.interntest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interntest.R;
import com.example.interntest.lists.MyWorkshopListObject;

import java.util.List;

public class MyWorkshopAdapter extends RecyclerView.Adapter<MyWorkshopAdapter.MyWorkshopHolder> {

    private Context context;
    private List<MyWorkshopListObject> list;

    public MyWorkshopAdapter(Context context,List<MyWorkshopListObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyWorkshopHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.my_workshop_items,viewGroup,false);

        return new MyWorkshopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyWorkshopHolder myWorkshopHolder, int i) {

        MyWorkshopListObject myWorkshop = list.get(i);

        myWorkshopHolder.workshopName.setText(myWorkshop.getMyWorkshop());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyWorkshopHolder extends RecyclerView.ViewHolder{

        TextView workshopName;

         MyWorkshopHolder(@NonNull View itemView) {
            super(itemView);

            workshopName = (TextView)itemView.findViewById(R.id.workshopName);
        }
    }
}
