package com.example.pomingpo.few_customview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pomingpo.few_customview.R;
import com.example.pomingpo.few_customview.customView.CircleInsideHaveTextView1;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleInsideHaveTextView1Fragment extends Fragment {


    @BindView(R.id.cv1_r)
    CircleInsideHaveTextView1 cv1R;
    @BindView(R.id.bt_change)
    Button btChange;
    Unbinder unbinder;

    public CircleInsideHaveTextView1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circle_inside_have_text_view1, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bt_change)
    public void onClick() {
        cv1R.setPresentage(randomWithRange(0, 100));
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
