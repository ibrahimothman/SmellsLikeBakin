package com.dell.smellslikebakin;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.listItemViewHolder> {
    
    @Override
    public listItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId() , parent , false);
        listItemViewHolder holder = new listItemViewHolder(view);
        return holder;
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(listItemViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount()
    {
        return Recipes.names.length;
    }

    public class listItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemImage;
        TextView itemText;
        private int mIndex;
        public listItemViewHolder(View itemView) {
            super(itemView);

            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemText = (TextView) itemView.findViewById(R.id.itemText);
            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            mIndex=position;
            itemImage.setImageResource(Recipes.resourceIds[position]);
            itemText.setText(Recipes.names[position]);
        }



        @Override
        public void onClick(View v) {
            onRecipeSelected(mIndex);
        }
    }

    protected abstract void onRecipeSelected(int mIndex);
}
