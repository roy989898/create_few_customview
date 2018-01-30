package com.example.pomingpo.few_customview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pomingpo.few_customview.R;
import com.example.pomingpo.few_customview.Util;
import com.example.pomingpo.few_customview.customView.PercentageCirclewithTwoLineText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    @BindView(R.id.pc)
    PercentageCirclewithTwoLineText pc;
    @BindView(R.id.ed_enter_second_text)
    EditText edEnterSecondText;
    @BindView(R.id.bt_change)
    Button btChange;
    Unbinder unbinder;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
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
        pc.setPercentage(Util.randomWithRange(0, 100));
        pc.setSecondLineText(edEnterSecondText.getText().toString());
    }
}
