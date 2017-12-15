package com.dell.smellslikebakin;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnRecipeSelectedInterface , GridFragment.OnRecipeSelectedInterface {

    public static final String LIST_FRAGMMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet=getResources().getBoolean(R.bool.is_tablet);
        if(!isTablet){
            //to avoid double fragmnets
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMMENT);
            if(savedFragment == null) {
                ListFragment fragment = new ListFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder , fragment ,LIST_FRAGMMENT );
                fragmentTransaction.commit();
            }
        }else {
            //to avoid double fragmnets
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMMENT);
            if(savedFragment == null) {
                GridFragment fragment = new GridFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder , fragment ,LIST_FRAGMMENT );
                fragmentTransaction.commit();


            }
        }


    }


    @Override
    public void onListRecipeSelected(int index) {
      ViewPagerFragment fragment = new ViewPagerFragment();
      Bundle bundle = new Bundle();
      bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
      fragment.setArguments(bundle);
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.placeHolder , fragment , VIEWPAGER_FRAGMENT);
      fragmentTransaction.addToBackStack(null);
      fragmentTransaction.commit();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);


    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualFragment fragment = new DualFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder , fragment , VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }
}
