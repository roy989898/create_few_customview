package com.example.pomingpo.few_customview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pomingpo.few_customview.GlideApp;
import com.example.pomingpo.few_customview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hk.com.poming.fewcustomviewlibrary.customView.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {


    @BindView(R.id.iv_circle)
    CircleImageView ivCircle;
    Unbinder unbinder;

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        unbinder = ButterKnife.bind(this, view);
        GlideApp
                .with(this)
                .load("https://i.imgur.com/iqkjwSO.jpg")
                .fitCenter()
                .into(ivCircle);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
