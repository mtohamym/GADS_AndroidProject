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
import com.tohamy.gads.Model.SkillIq;

import java.util.List;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.SkillIqViewHolder> {

    private List<SkillIq> iq ;
    private Context context ;


    @NonNull
    @Override
    public SkillIqAdapter.SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SkillIqAdapter.SkillIqViewHolder(LayoutInflater.from(context).inflate(R.layout.card_design,parent,false));
    }

    public void setSkill(List<SkillIq> iq) {
        this.iq = iq;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.SkillIqViewHolder holder, int position) {
        SkillIq iqView = iq.get(position);
        Picasso.get().load(iqView.getBadgeUrl()).into(holder.badge);
        holder.country.setText(iqView.getCountry());
        holder.Score.setText(iqView.getScore());
        holder.name.setText(iqView.getName());
        holder.topic.setText("SKILL IQ SCORE ");
    }

    @Override
    public int getItemCount() {
        return iq.size();
    }

    public class SkillIqViewHolder extends RecyclerView.ViewHolder {
        TextView name , country , Score , topic;
        ImageView badge;

        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            Score = itemView.findViewById(R.id.hours_score);
            topic = itemView.findViewById(R.id.topic);
            badge = itemView.findViewById(R.id.badgeIM);

        }
    }
}
