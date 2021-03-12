package com.preciousneema.food;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.preciousneema.food.model.Food;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Food> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<Food> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.allmenu_recyler_items, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.name = (TextView) convertView.findViewById(R.id.all_menu_name);
            viewHolder.flavor = (TextView) convertView.findViewById(R.id.all_menu_note);
            viewHolder.rating = (TextView) convertView.findViewById(R.id.all_menu_rating);
            viewHolder.delivery_time = (TextView) convertView.findViewById(R.id.all_menu_deliverytime);
            viewHolder.delivery_charges = (TextView) convertView.findViewById(R.id.all_menu_delivery_charge);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.all_menu_image);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        Food food = data.get(position);//modify here
        viewHolder.name.setText(food.getName());//modify here
        viewHolder.flavor.setText(food.getFlavor());//modify here
        viewHolder.rating.setText(food.getRating());//modify here
        viewHolder.delivery_time.setText(food.getDelivery_time()+" mins");//modify here
        viewHolder.delivery_charges.setText("Ksh "+food.getDelivery_charges());//modify here
        viewHolder.imageView.setImageResource(food.getPhoto());
        return convertView;

    }
    static class ViewHolder {
        TextView name,flavor,rating,delivery_time,delivery_charges;
        ImageView imageView;
    }

}