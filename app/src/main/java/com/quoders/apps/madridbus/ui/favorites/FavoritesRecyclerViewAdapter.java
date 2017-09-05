package com.quoders.apps.madridbus.ui.favorites;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;
import com.quoders.apps.madridbus.ui.favorites.FavoritesFragment.OnListFragmentInteractionListener;

import java.util.List;

public class FavoritesRecyclerViewAdapter extends RecyclerView.Adapter<FavoritesRecyclerViewAdapter.ViewHolder> {

    private List<FavoriteBase> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FavoritesRecyclerViewAdapter(List<FavoriteBase> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_favorites, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTvStopName.setText(mValues.get(position).getStop().getName());
        holder.mTvTimeNext.setText(mValues.get(position).getTimeNext());

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    public void setItems(List<FavoriteBase> stops) {
        mValues = stops;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTvLineName;
        public final TextView mTvStopName;
        public final TextView mTvTimeNext;

        public FavoriteBase mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTvLineName = (TextView) view.findViewById(R.id.textViewLineName);
            mTvStopName = (TextView) view.findViewById(R.id.textViewStopName);
            mTvTimeNext = (TextView) view.findViewById(R.id.textViewTimeNext);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTvStopName.getText() + "'";
        }
    }
}
