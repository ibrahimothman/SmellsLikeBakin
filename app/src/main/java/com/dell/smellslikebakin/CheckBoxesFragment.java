package com.dell.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public abstract class CheckBoxesFragment extends Fragment {
    private static final String KEY_CHECKBOX_STATE = "Key_CheckBox_state" ;
    private CheckBox [] mCheckBox;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);

        View view = inflater.inflate(R.layout.fragment_checkboxest, container ,false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
        String [] contents = getcontent(index);

        mCheckBox=new CheckBox[contents.length];
        boolean[]checkedBoxes = new boolean[mCheckBox.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKBOX_STATE) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOX_STATE);
        }

        setUpCheckBoxes(contents,linearLayout,checkedBoxes);

        return view;
    }

    public abstract String[] getcontent(int index);


    private void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes){
        int i =0;
        for (String ingredient:contents){
            mCheckBox[i] = new CheckBox(getActivity());
            mCheckBox[i].setText(ingredient);
            mCheckBox[i].setPadding(8,16,8,16);
            mCheckBox[i].setTextSize(20f);
            mCheckBox[i].setChecked(checkedBoxes[i]);
            container.addView(mCheckBox[i]);
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[]stateOfCheckBoxes = new boolean[mCheckBox.length];
        int i =0;
        for (CheckBox chechBoxState : mCheckBox ){
            stateOfCheckBoxes[i]=chechBoxState.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKBOX_STATE,stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
