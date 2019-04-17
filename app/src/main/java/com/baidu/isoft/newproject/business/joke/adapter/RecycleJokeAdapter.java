/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.business.joke.adapter;

import com.baidu.isoft.newproject.R;
import com.baidu.isoft.newproject.bean.JokeBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleJokeAdapter extends RecyclerView.Adapter<RecycleJokeAdapter.JokeViewHolder> {

    private Context context;
    private JokeBean jokeBean;

    public RecycleJokeAdapter(Context context, JokeBean jokeBean){
        this.context = context;
        this.jokeBean = jokeBean;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_joke, parent, false);

        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        holder.jokeTv.setText(jokeBean.result.data.get(position).content);
    }

    @Override
    public int getItemCount() {
        return jokeBean.result.data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class JokeViewHolder extends RecyclerView.ViewHolder{

        private final TextView jokeTv;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            jokeTv = itemView.findViewById(R.id.include_layout_joke_tv);

        }
    }




}
