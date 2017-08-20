package com.quoders.apps.madridbus.ui.favorites;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quoders.apps.madridbus.BaseFragment;
import com.quoders.apps.madridbus.MadridBusApplication;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.favorites.FavoritesRepositoryModule;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class FavoritesFragment extends BaseFragment implements FavoritesContract.View {

    public static final String FRAGMENT_TAG = "com.quoders.apps.madridbus.ui.favorites.FavoritesFragment.FRAGMENT_TAG";

    private OnListFragmentInteractionListener mListener;

    private ContentLoadingProgressBar mProgressBar;
    private ImageView mIvFavorites;
    private TextView mTvFavoritesMsg;

    private FavoritesRecyclerViewAdapter mAdapter;

    @Inject
    FavoritesPresenter mPresenter;


    public FavoritesFragment() {
    }

    @SuppressWarnings("unused")
    public static FavoritesFragment newInstance(int columnCount) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }

        DaggerFavoritesComponent.builder()
                .applicationComponent(((MadridBusApplication)getActivity().getApplication()).getApplicationComponent())
                .favoritesPresenterModule(new FavoritesPresenterModule(this))
                .favoritesRepositoryModule(new FavoritesRepositoryModule())
                .build().inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites_list, container, false);
        initWidgets(view);
        initFavoritesListRecyclerView(view);
        mPresenter.start();
        return view;
    }

    private void initWidgets(View view) {
        mProgressBar = (ContentLoadingProgressBar)view.findViewById(R.id.progressBarFavoritesList);
        mIvFavorites = (ImageView)view.findViewById(R.id.imageViewFavorites);
        mTvFavoritesMsg = (TextView)view.findViewById(R.id.textViewFavorites);
    }

    private void initFavoritesListRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new FavoritesRecyclerViewAdapter(new ArrayList<>(), mListener);
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
    public void setPresenter(FavoritesContract.Presenter presenter) {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.show();
    }

    @Override
    public void setFavoritesList(List<FavoriteBase> resultValues) {
        mAdapter.setItems(resultValues);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorLoadingList() {
        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.error_dialog_generic_title)
                .setMessage(R.string.error_dialog_favorites_error_message)
                .setNeutralButton(R.string.dialog_button_neutral, null)
                .show();
    }

    @Override
    public void dismissProgressBar() {
        mProgressBar.hide();
    }

    @Override
    public void showEmptyFavoritesMessage() {
        mTvFavoritesMsg.setVisibility(View.VISIBLE);
        mIvFavorites.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyFavoritesMessage() {
        mTvFavoritesMsg.setVisibility(View.GONE);
        mIvFavorites.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.stop();
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(FavoriteBase item);
    }
}
