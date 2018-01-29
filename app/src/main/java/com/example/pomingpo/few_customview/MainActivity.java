package com.example.pomingpo.few_customview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.pomingpo.few_customview.Fragment.CircleInsideHaveTextView1Fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ContentPagerAdapter adapter = new ContentPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentArrayList(createFragmentList());

        vp.setAdapter(adapter);


    }


    private ArrayList<Fragment> createFragmentList() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new CircleInsideHaveTextView1Fragment());
        list.add(new CircleInsideHaveTextView1Fragment());

        return list;

    }


}
