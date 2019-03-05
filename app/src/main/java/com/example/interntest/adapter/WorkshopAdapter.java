package com.example.interntest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interntest.R;
import com.example.interntest.activities.ApplyWorkshop;
import com.example.interntest.lists.AllWorkshopListObject;

import java.util.List;

import static com.example.interntest.utils.Constants.BODY;
import static com.example.interntest.utils.Constants.TOPIC;


public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.WorkshopHolder>{

    private Context context;
    private List<AllWorkshopListObject> list;

    public WorkshopAdapter(Context context,List<AllWorkshopListObject> list){
        this.context= context;
        this.list = list;
    }

    @NonNull
    @Override
    public WorkshopHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.workshop_items,viewGroup,false);
        return new WorkshopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorkshopHolder workshopHolder, int i) {

        AllWorkshopListObject workshopListObject = list.get(i);

        workshopHolder.workShopNameTV.setText(workshopListObject.getWorkshopName());

        workshopHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AllWorkshopListObject temp = list.get(workshopHolder.getAdapterPosition());

                Intent goApply = new Intent(context, ApplyWorkshop.class);
                goApply.putExtra(TOPIC,temp.getWorkshopName());
                goApply.putExtra(BODY,temp.getWorkshopDescription());

                context.startActivity(goApply);

                Toast.makeText(context, temp.getWorkshopDescription(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WorkshopHolder extends RecyclerView.ViewHolder{

        TextView workShopNameTV;

        WorkshopHolder(@NonNull View itemView) {
            super(itemView);

            workShopNameTV = (TextView)itemView.findViewById(R.id.workshopName);
        }
    }
}
