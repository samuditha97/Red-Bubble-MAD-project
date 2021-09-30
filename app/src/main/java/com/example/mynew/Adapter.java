package com.example.mynew;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    Activity activity;
    List<Model> notesList;
    List<Model> newList;


    public Adapter(Context context, Activity activity, List<Model> notesList) {
        this.context = context;
        this.activity = activity;
        this.notesList = notesList;
        newList = new ArrayList<>(notesList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_note,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(notesList.get(position).getTitle());
        holder.description.setText(notesList.get(position).getDescription());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,UpdateNotesActivity.class);

                intent.putExtra("title",notesList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("description",notesList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("id",notesList.get(holder.getAdapterPosition()).getId());

                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,description;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.note_title);
            description=itemView.findViewById(R.id.note_description);
            layout=itemView.findViewById(R.id.note_layout);
        }
    }

    public List<Model> getList() {
        return notesList;
    }
}
