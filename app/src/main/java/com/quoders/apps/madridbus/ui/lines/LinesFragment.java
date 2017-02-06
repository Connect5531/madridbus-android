package com.quoders.apps.madridbus.ui.lines;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quoders.apps.madridbus.MadridBusApplication;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.rest.LineInfoEmt;

import java.util.ArrayList;

import javax.inject.Inject;

public class LinesFragment extends Fragment implements LinesContract.View {

    public static final String FRAGMENT_TAG = "com.quoders.apps.madridbus.ui.lines.LinesFragment.FRAGMENT_TAG";

    private OnListFragmentInteractionListener mListener;
    private LinesRecyclerViewAdapter mAdapter;

    @Inject
    LinesPresenter mPresenter;

    public LinesFragment() {
    }

    public static LinesFragment newInstance() {
        LinesFragment fragment = new LinesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLinesComponent.builder()
                .madridBusAppComponent(((MadridBusApplication)getActivity().getApplication()).getApplicationComponent())
                .build().inject(this);

        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lines_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            mAdapter = new LinesRecyclerViewAdapter(new ArrayList<LineInfoEmt>(), mListener);
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
    public void setPresenter(LinesContract.Presenter presenter) {

    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(LineInfoEmt item);
    }
}
