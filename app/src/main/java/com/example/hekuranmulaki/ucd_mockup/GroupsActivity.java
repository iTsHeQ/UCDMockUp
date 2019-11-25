package com.example.hekuranmulaki.ucd_mockup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    //

    private List<GroupItem> groupItems;
    private ArrayList<String> myGroups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        recyclerView = (RecyclerView) findViewById(R.id.groupsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myGroups.add("@Home");
        myGroups.add("Party vom 12.12.19");



        groupItems = new ArrayList<>();

        for (int i = 0; i< myGroups.size(); i++){
            GroupItem groupItem = new GroupItem(
                    myGroups.get(i)
            );
            groupItems.add(groupItem);
        }

        adapter = new GroupAdapter(groupItems, this);

        recyclerView.setAdapter(adapter);


    }
}
