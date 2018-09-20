package com.project.androidtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.androidtest.R;
import com.project.androidtest.pojo.Row;

import java.util.List;

import utils.PicassoTrustAll;

/**
 * Created by tabdul on 19/09/2018.
 */


public class DataLodingAdapter extends RecyclerView.Adapter<DataLodingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Row> rowListData;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public DataLodingAdapter(Context mContext, List<Row> albumList) {
        this.mContext = mContext;
        this.rowListData = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Row data = rowListData.get(position);
        holder.title.setText(data.getTitle());
        holder.count.setText(data.getDescription());

        // loading album cover using Glide library
        //Glide.with(mContext).load(data.getImageHref());
        if(data.getImageHref() != null) {
            PicassoTrustAll.getInstance(mContext)
                    .load(data.getImageHref().toString())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.thumbnail);
        }else{
            PicassoTrustAll.getInstance(mContext)
                    .load("http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png")
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.thumbnail);
        }

    }

    @Override
    public int getItemCount() {
        return rowListData.size();
    }
}
