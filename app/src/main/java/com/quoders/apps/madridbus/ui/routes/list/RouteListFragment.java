package com.quoders.apps.madridbus.ui.routes.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.ArrayList;
import java.util.List;


public class RouteListFragment extends Fragment implements RouteListViewContract.View {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private RouteListRecyclerViewAdapter mAdapter;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RouteListFragment() {
    }

    public static RouteListFragment newInstance(int columnCount) {
        RouteListFragment fragment = new RouteListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        mAdapter = new RouteListRecyclerViewAdapter(new ArrayList<StopBase>(), mListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(RouteListViewContract.Presenter presenter) {

    }

    @Override
    public void displayRoute(List<StopBase> stops) {
        mAdapter.setItems(stops);
        mAdapter.notifyDataSetChanged();
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(StopBase item);
    }
}
