package com.quoders.apps.madridbus.ui.lines;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quoders.apps.madridbus.BaseFragment;
import com.quoders.apps.madridbus.MadridBusApplication;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.lines.di.LinesRepositoryModule;
import com.quoders.apps.madridbus.model.LineBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LinesFragment extends BaseFragment implements LinesContract.View {

    public static final String FRAGMENT_TAG = "com.quoders.apps.madridbus.ui.lines.LinesFragment.FRAGMENT_TAG";

    ContentLoadingProgressBar mProgressBar;

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
                .applicationComponent(((MadridBusApplication)getActivity().getApplication()).getApplicationComponent())
                .linesPresenterModule(new LinesPresenterModule(this))
                .linesRepositoryModule(new LinesRepositoryModule())
                .build().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lines_list, container, false);
        mProgressBar = (ContentLoadingProgressBar)view.findViewById(R.id.progressBarListsList);
        initLinesListRecyclerView(view);
        mPresenter.start();
        return view;
    }

    private void initLinesListRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new LinesRecyclerViewAdapter(new ArrayList<LineBase>(), mListener);
        recyclerView.setAdapter(mAdapter);
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

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setLinesList(List<LineBase> resultValues) {
        mAdapter.setItems(resultValues);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorLoadingList() {
        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.error_dialog_generic_title)
                .setMessage(R.string.error_dialog_line_list_message)
                .setNeutralButton(R.string.dialog_button_neutral, null)
                .show();

    }

    @Override
    public void dismissProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(LineBase item);
    }
}
