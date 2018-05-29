package com.laurinware.gamebrain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by javil on 21/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    public LayoutInflater inflater = null;
    private List<String> mGames;
    private ListItemOnClickInterface listItemOnClickInterface;

    public RecyclerViewAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        if (context instanceof ListItemOnClickInterface)
            listItemOnClickInterface = (ListItemOnClickInterface) context;
    }

    public RecyclerViewAdapter(List<String> courses) {
        this.mGames = courses;
    }

    public RecyclerViewAdapter(Context context, List<String> games, ListItemOnClickInterface customOnClick) {
        this.mGames = games;
        this.inflater = LayoutInflater.from(context);
        this.listItemOnClickInterface = customOnClick;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder
            (ViewGroup viewGroup, int type) {

        View view =
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.recyclerview_item,viewGroup,false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        // Colocar el nombre del curso y el profesor en el viewHolder
        viewHolder.gameName.setText(mGames.get(i));
       // viewHolder.teacherName.setText(mCourses.get(i));
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    public void addCourse(String course) {
        mGames.add(course);
        notifyDataSetChanged();
    }

    public void setNames(List<String> mcourses) {
        this.mGames = mcourses;
        notifyDataSetChanged();
    }

    public final class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public TextView gameName;
        public TextView Name;

        public ViewHolder(View itemView) {
            super(itemView);
            // Inicializar los dos TextView
            gameName = (TextView) itemView.findViewById(R.id.tvName);
            //teacherName = (TextView) itemView.findViewById(R.id.tvTeacher);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            listItemOnClickInterface.onItemClick(mGames.get(getLayoutPosition()));
        }
    }
}
