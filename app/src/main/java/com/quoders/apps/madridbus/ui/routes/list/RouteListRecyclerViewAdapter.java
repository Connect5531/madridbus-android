package com.quoders.apps.madridbus.ui.routes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.List;

public class RouteListRecyclerViewAdapter extends RecyclerView.Adapter<RouteListRecyclerViewAdapter.ViewHolder> {

    private List<StopBase> mValues;
    private final RouteListFragment.OnListFragmentInteractionListener mListener;

    public RouteListRecyclerViewAdapter(List<StopBase> items, RouteListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_routestop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCode.setText(mValues.get(position).getCode());
        holder.mName.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });

        holder.mIvFavorite.setOnClickListener(v -> {
            if(null != mListener) {
                mListener.onSetFavoriteStop(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setItems(List<StopBase> stops) {
        mValues = stops;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCode;
        public final TextView mName;
        public final ImageView mIvFavorite;

        public StopBase mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCode = (TextView) view.findViewById(R.id.stopCode);
            mName = (TextView) view.findViewById(R.id.stopName);
            mIvFavorite = (ImageView) view.findViewById(R.id.imageViewStopFavorite);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mName.getText() + "'";
        }
    }
}
