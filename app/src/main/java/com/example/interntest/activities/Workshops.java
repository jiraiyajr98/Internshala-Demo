package com.example.interntest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.interntest.R;
import com.example.interntest.adapter.WorkshopAdapter;
import com.example.interntest.lists.AllWorkshopListObject;
import com.example.interntest.lists.MyWorkshopListObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.interntest.utils.TableUtils.getMyWorkshopTableData;
import static com.example.interntest.utils.TableUtils.getWorkshopTableData;

public class Workshops extends AppCompatActivity {

    private List<AllWorkshopListObject> list= new ArrayList<>();
    WorkshopAdapter adapter;
    public static final String TAG ="WORKSHOP";
    boolean go = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter = new WorkshopAdapter(Workshops.this,list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(Workshops.this,2));

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<AllWorkshopListObject> temp = new ArrayList<>();
        List<MyWorkshopListObject> temp2 = new ArrayList<>(getMyWorkshopTableData(Workshops.this));


        list.addAll(getWorkshopTableData(Workshops.this));

        Log.d(TAG,"Size :B "+list.size());

        for(AllWorkshopListObject workshopListObject: list)
        {
            for(MyWorkshopListObject myWorkshopListObject: temp2)
            {
                Log.d(TAG,workshopListObject.getWorkshopName()+" : "+myWorkshopListObject.getMyWorkshop());
                if(workshopListObject.getWorkshopName().equals(myWorkshopListObject.getMyWorkshop()))
                {
                    Log.d(TAG,workshopListObject.getWorkshopName()+" :TRUE: "+myWorkshopListObject.getMyWorkshop());
                    temp.add(workshopListObject);
                }
            }

        }

        list.removeAll(temp);

        Log.d(TAG,"Size :A "+list.size());


        adapter.notifyItemRangeInserted(0,list.size());
    }

    @Override
    protected void onPause() {
        super.onPause();

        int size = list.size();
        list.clear();
        adapter.notifyItemRangeRemoved(0,size);

    }
}
