package com.quoders.apps.madridbus.ui.favorites;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quoders.apps.madridbus.BaseFragment;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;
import com.quoders.apps.madridbus.ui.favorites.dummy.DummyContent;
import com.quoders.apps.madridbus.ui.favorites.dummy.DummyContent.DummyItem;

import java.util.List;


public class FavoritesFragment extends BaseFragment implements FavoritesContract.View {

    public static final String FRAGMENT_TAG = "com.quoders.apps.madridbus.ui.favorites.FavoritesFragment.FRAGMENT_TAG";

    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    public FavoritesFragment() {
    }

    @SuppressWarnings("unused")
    public static FavoritesFragment newInstance(int columnCount) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new FavoritesRecyclerViewAdapter(DummyContent.ITEMS, mListener));
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
    public void setPresenter(FavoritesContract.Presenter presenter) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void setFavoritesList(List<FavoriteBase> resultValues) {

    }

    @Override
    public void showErrorLoadingList() {

    }

    @Override
    public void dismissProgressBar() {

    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item);
    }
}
