package com.example.mvvm.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.service.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.NoteHolder> {
    private List<Posts> postList = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_post, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Posts currentPost = postList.get(position);
        holder.textViewUserId.setText(String.valueOf(currentPost.getTitle()));
        holder.textViewId.setText(String.valueOf(currentPost.getId()));
        holder.textViewBody.setText(String.valueOf(currentPost.getBody()));
        holder.textViewTitle.setText(currentPost.getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPostList(List<Posts> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewUserId;
        private TextView textViewId;
        private TextView textViewTitle;
        private TextView textViewBody;

        public NoteHolder(View itemView) {
            super(itemView);
            textViewUserId = itemView.findViewById(R.id.tv_userid);
            textViewId = itemView.findViewById(R.id.tv_id);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewBody = itemView.findViewById(R.id.tv_body);
        }
    }
}