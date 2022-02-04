package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataList;
    RecyclerView recycle;
    Button addElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addElement = (Button) findViewById(R.id.addElement);
        setButtonListenerAction();

        recycle = (RecyclerView) findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        dataList = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            dataList.add("#" + i + " This is a string");
        }

        DataAdapter recycleAdapter = new DataAdapter(dataList);
        recycle.setAdapter(recycleAdapter);

    }

    public void setButtonListenerAction() {
        addElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addElementToList();
            }
        });
    }

    public void addElementToList() {
        dataList.add("#" + dataList.size() + " This is a string");
        recycle.getAdapter().notifyItemInserted(dataList.size());
        recycle.smoothScrollToPosition(dataList.size());
    }

}