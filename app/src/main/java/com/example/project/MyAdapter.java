package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.Item;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Item> itemList;
    private DecimalFormat formatter;
    private Context context;


    public MyAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
        formatter = new DecimalFormat("#,##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);

        int drawableResourceId = holder.itemView.getResources().getIdentifier(item.getPic(), "drawable", holder.imageView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageView);

        holder.titleTxt.setText(item.getTitle());
        holder.addressTxt.setText(item.getAddress());
        holder.distanceTxt.setText(formatter.format(item.getDistance()) + "Km");

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", item);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTxt;
        public TextView addressTxt;
        public TextView distanceTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pic);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            addressTxt = itemView.findViewById(R.id.addressTxt);
            distanceTxt = itemView.findViewById(R.id.distanceTxt);
        }
    }
}
