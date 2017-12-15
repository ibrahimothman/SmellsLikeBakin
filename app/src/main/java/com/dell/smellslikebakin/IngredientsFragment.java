package com.dell.smellslikebakin;

/**
 * Created by dell on 7/11/2017.
 */

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getcontent(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
