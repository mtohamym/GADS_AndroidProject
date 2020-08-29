package com.tohamy.gads.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tohamy.gads.R;
import com.tohamy.gads.Model.Hours;

import java.util.List;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.HoursViewHolder> {

   private List<Hours> hours ;
   private Context context ;

    public void setHours(List<Hours> hours) {
        this.hours = hours;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new HoursAdapter.HoursViewHolder(LayoutInflater.from(context).inflate(R.layout.card_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder holder, int position) {
        Hours hoursView = hours.get(position);
        Picasso.get().load(hoursView.getBadgeUrl()).into(holder.badge);
        holder.country.setText(hoursView.getCountry());
        holder.hoursCount.setText(hoursView.getHours());
        holder.name.setText(hoursView.getName());
        holder.topic.setText("Learning Hours ");
    }

    @Override
    public int getItemCount() {
        return hours.size();
    }

    public class HoursViewHolder  extends RecyclerView.ViewHolder{
        TextView name , country , hoursCount , topic;
        ImageView badge;

        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            hoursCount = itemView.findViewById(R.id.hours_score);
            topic = itemView.findViewById(R.id.topic);
            badge = itemView.findViewById(R.id.badgeIM);
        }
    }
}
