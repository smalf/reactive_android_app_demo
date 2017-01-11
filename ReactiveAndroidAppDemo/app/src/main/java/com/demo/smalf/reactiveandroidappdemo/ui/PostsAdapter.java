package com.demo.smalf.reactiveandroidappdemo.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.smalf.reactiveandroidappdemo.R;
import com.demo.smalf.reactiveandroidappdemo.data.posts.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the {@link android.support.v7.widget.RecyclerView.Adapter} for displaying posts.
 *
 * @author Serhiy Malofeev.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {
    private static final String TAG = PostsAdapter.class.getSimpleName();

    /**
     * Defines contract for item click listener.
     */
    public interface OnItemClickedListener {

        /**
         * Called when recycler view item was clicked.
         *
         * @param view that was clicked
         * @param position of clicked view
         */
        void onItemClicked(View view, int position);
    }

    private final List<Post> posts;
    private OnItemClickedListener onItemClickedListener;

    public PostsAdapter(final List<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        final Post post = posts.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvText.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends  RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView tvTitle;
        TextView tvText;

        public PostHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);

            itemView.setClickable(true);
            itemView.setFocusable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickedListener != null) {
                onItemClickedListener.onItemClicked(view, getAdapterPosition());
            }
        }
    }
}
