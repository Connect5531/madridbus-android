package com.quoders.apps.madridbus.ui.stopInfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.arrivals.Arrive;

import java.util.List;

public class ArrivalsRecyclerViewAdapter extends RecyclerView.Adapter<ArrivalsRecyclerViewAdapter.ViewHolder> {

    private List<Arrive> mValues;
    private final ArrivalItemClickListener mListener;

    public ArrivalsRecyclerViewAdapter(List<Arrive> items, ArrivalItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stop_info_arrival_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTvLineName.setText(mValues.get(position).getLineId());
        holder.mTvTimeLeft.setText(String.valueOf(mValues.get(position).getBusTimeLeft()));

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onArrivalClick(holder.mItem);
            }
        });
    }

    void setItems(List<Arrive> resultValues) {
        mValues = resultValues;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTvLineName;
        final TextView mTvTimeLeft;
        Arrive mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTvLineName = (TextView) view.findViewById(R.id.textViewArrivalLineName);
            mTvTimeLeft = (TextView) view.findViewById(R.id.textViewArrivalTimeLeft);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTvLineName.getText() + "'";
        }
    }
}
