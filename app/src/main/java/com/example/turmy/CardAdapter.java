package com.example.turmy;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import com.google.android.material.transition.Hold;

import java.util.List;
import java.util.Objects;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<String> titles;
    private List<String> schools;
    private List<String> dates;
    private List<String> situations;

    public CardAdapter(List<String> titles, List<String> schools, List<String> dates, List<String> situations) {
        this.titles = titles;
        this.schools = schools;
        this.dates = dates;
        this.situations = situations;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.titleTextView.setText(titles.get(position));
        holder.schoolTextView.setText(schools.get(position));
        holder.dateTextView.setText(dates.get(position));

        if (Objects.equals(situations.get(position), "ATRASADO")){
            holder.situationTextView.setBackgroundColor(Color.parseColor("#E74726"));
        }
        else if (Objects.equals(situations.get(position), "CONFIRMADO")){
            holder.situationTextView.setBackgroundColor(Color.parseColor("#60AE1E"));
        }
        else if (Objects.equals(situations.get(position), "VENCIMENTO")){
            holder.situationTextView.setBackgroundColor(Color.parseColor("#DCAC10"));
        }
        holder.situationTextView.setText(situations.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, schoolTextView, dateTextView, situationTextView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.card_title);
            schoolTextView = itemView.findViewById(R.id.card_school);
            dateTextView = itemView.findViewById(R.id.card_date);
            situationTextView = itemView.findViewById(R.id.card_situation);
        }
    }
}
