package com.example.interntest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.interntest.R;
import com.example.interntest.adapter.MyWorkshopAdapter;
import com.example.interntest.lists.MyWorkshopListObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.interntest.utils.TableUtils.getMyWorkshopTableData;


public class MyWorkshop extends AppCompatActivity {

    private MyWorkshopAdapter adapter;
    private List<MyWorkshopListObject> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workshop);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter = new MyWorkshopAdapter(MyWorkshop.this,list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyWorkshop.this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        list.addAll(getMyWorkshopTableData(MyWorkshop.this));
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
