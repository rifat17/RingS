package com.example.ringersschool.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ringersschool.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashBoardRecyeclerViewAdapter extends RecyclerView.Adapter<DashBoardRecyeclerViewAdapter.ViewHolder>{
    int []vi;

    String[] values;
    Context context1;

    public DashBoardRecyeclerViewAdapter(Context context2, String[] values2, int[] v1){

        values = values2;
        vi=v1;

        context1 = context2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView image;

        public ViewHolder(View v){

            super(v);

            textView = (TextView)v.findViewById(R.id.Sample_layout_dash_textView);
            image=v.findViewById(R.id.Sample_layout_dash_image);

        }
    }

    @Override
    public DashBoardRecyeclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(context1).inflate(R.layout.sample_layout_dashboard,parent,false);

        ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position){

        Vholder.textView.setText(values[position]);
        Vholder.image.setImageResource(vi[position]);

        Vholder.textView.setBackgroundColor(Color.WHITE);
       Vholder.textView.setTextColor(Color.BLACK);

    }

    @Override
    public int getItemCount(){

        return values.length;
    }
}