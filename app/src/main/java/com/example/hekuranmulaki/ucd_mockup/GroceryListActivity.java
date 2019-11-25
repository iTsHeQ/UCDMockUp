package com.example.hekuranmulaki.ucd_mockup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GroceryListActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Button addGrocery;
    private List<GroupItem> groupItems;

    private String[] filters;
    private boolean[] checkedGroceries;

    //

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_list);

        recyclerView = (RecyclerView) findViewById(R.id.grocerieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addGrocery = (Button) findViewById(R.id.addItemBTN);
        groupItems = new ArrayList<>();
        filters = new String[1];
        filters[0] = "important";

        checkedGroceries = new boolean[1];


        addGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText addGroceries = new EditText(GroceryListActivity.this);
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GroceryListActivity.this);
                alertDialogBuilder.setView(addGroceries);
                alertDialogBuilder.setTitle("Add Grocerie");

                alertDialogBuilder.setMultiChoiceItems(filters, checkedGroceries, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                alertDialogBuilder.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String grocerie = String.valueOf(addGroceries.getText());
                        System.out.println(grocerie);
                        GroupItem groupItem = new GroupItem(
                                grocerie
                        );
                        groupItems.add(groupItem);

                        //add parameter to the Adapter (true or false for importance) to mark the color red

                        adapter = new GrocerieListAdapter(groupItems, GroceryListActivity.this);

                        recyclerView.setAdapter(adapter);
                    }
                });


                alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });
    }


}
