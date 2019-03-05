package com.example.interntest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interntest.R;
import com.example.interntest.lists.MyWorkshopListObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.interntest.utils.Constants.BODY;
import static com.example.interntest.utils.Constants.TOPIC;
import static com.example.interntest.utils.TableUtils.deleteTableShortcut;
import static com.example.interntest.utils.TableUtils.getMyWorkshopTableData;
import static com.example.interntest.utils.TableUtils.myWorkshopDataInsertion;

public class ApplyWorkshop extends AppCompatActivity {

    private TextView name;
    private TextView body;
    private Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_workshop);

        name = findViewById(R.id.name);
        body = findViewById(R.id.body);
        apply = findViewById(R.id.apply);

        name.setText(getIntent().getStringExtra(TOPIC));
        body.setText(getIntent().getStringExtra(BODY));

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<MyWorkshopListObject> tempList = new ArrayList<>(getMyWorkshopTableData(ApplyWorkshop.this));

                deleteTableShortcut(ApplyWorkshop.this);

                tempList.add(new MyWorkshopListObject(name.getText().toString()));

                for(MyWorkshopListObject obj: tempList)
                {
                    myWorkshopDataInsertion(ApplyWorkshop.this,obj.getMyWorkshop());
                }

                Toast.makeText(ApplyWorkshop.this, "Applied Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
