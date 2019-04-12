/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.adapter;

import com.baidu.isoft.newproject.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewPager2ViewHolder> {


    private Context context;

    public ViewPager2Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewPager2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_viewpager2, parent, false);

        return new ViewPager2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPager2ViewHolder holder, int position) {
        holder.layoutViewPager2Tv.setText(""+position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewPager2ViewHolder extends RecyclerView.ViewHolder {

        private final TextView layoutViewPager2Tv;

        public ViewPager2ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutViewPager2Tv = itemView.findViewById(R.id.layout_viewpager2_tv);
        }
    }

}
