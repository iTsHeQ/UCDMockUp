package com.example.hekuranmulaki.ucd_mockup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GrocerieListAdapter extends RecyclerView.Adapter<GrocerieListAdapter.ViewHolder> {

    //
    private List<GroupItem> groupItems;
    private Context context;

    public GrocerieListAdapter(List<GroupItem> groupItems, Context context) {
        this.groupItems = groupItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocerie_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GroupItem groupItem = groupItems.get(position);

        holder.textViewHead.setText(groupItem.getHead());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked");
            }
        });
    }


    @Override
    public int getItemCount() {
        return groupItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHeading);
            parentLayout = itemView.findViewById(R.id.list_card_view);
        }
    }
}
