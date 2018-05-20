package com.example.rxretrofitcashdagger.rxretrofitcashdagger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DataRecycleViewAdapter extends RecyclerView.Adapter<DataRecycleViewAdapter.DataViewHolder> {
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";
    private Context mContext;
    private ArrayList<MovieInfo> dataArrayList;

    public DataRecycleViewAdapter(Context context) {
        this.mContext = context;
        this.dataArrayList = new ArrayList<>();

    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.textRName.setText(dataArrayList.get(position).getOriginalTitle());
        holder.textDate.setText(dataArrayList.get(position).getReleaseDate());
        Picasso.with(mContext)
                .load(IMAGE_BASE_URL + dataArrayList.get(position).getPosterPath()).centerCrop().resize(60,60)
                .into(holder.imageView);
        //put all ur UI
    }

    public void setDataArrayList(ArrayList<MovieInfo> arrayList) {
        if (dataArrayList == null) {
            return;
        }
        dataArrayList.clear();
        dataArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView textRName;
        TextView textDate;
        ImageView imageView;

        public DataViewHolder(View itemView) {
            super(itemView);
            textRName = (TextView) itemView.findViewById(R.id.txtDisplayName);
            textDate = (TextView) itemView.findViewById(R.id.txtDate);
            imageView = (ImageView) itemView.findViewById(R.id.circleView);
        }
    }

}

