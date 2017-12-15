package com.dell.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 7/12/2017.
 */

public class GridFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GridFragment.OnRecipeSelectedInterface listener = (GridFragment.OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        GridAdapter gridAdapter = new GridAdapter(listener);
        recyclerView.setAdapter(gridAdapter);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidt=displayMetrics.widthPixels/displayMetrics.density;
        int nColumns = (int) (dpWidt / 200);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),nColumns);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }




}
