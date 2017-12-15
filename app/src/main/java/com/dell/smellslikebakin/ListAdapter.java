package com.dell.smellslikebakin;

/**
 * Created by dell on 7/12/2017.
 */

public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int mIndex) {
        mListener.onListRecipeSelected(mIndex);
    }
}
