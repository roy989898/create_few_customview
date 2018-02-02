package com.example.pomingpo.few_customview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pomingpo.few_customview.CustomCmarker.MyMarkerView;
import com.example.pomingpo.few_customview.CustomFormatter.MyXAxisValueFormatter;
import com.example.pomingpo.few_customview.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.MarkerImage;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChartLibraryFragment extends Fragment {


    @BindView(R.id.chart)
    LineChart chart;
    Unbinder unbinder;

    public ChartLibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart_library, container, false);
        unbinder = ButterKnife.bind(this, view);

        chart.setData(createData());
        chart.getAxisRight().setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new MyXAxisValueFormatter());
        xAxis.setSpaceMin(1);


/*
//        set the click popup temp

        MarkerImage marker = new MarkerImage(getContext(), R.mipmap.ic_launcher);
        chart.setMarker(marker);

*/
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        chart.setMarker(mv);


        chart.invalidate(); // refresh

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private LineData createData() {
        List<Entry> entries = new ArrayList<Entry>();
        for (int i = 0; i < 5; i++) {
            entries.add(new Entry(i, i * i, getResources().getDrawable(R.mipmap.ic_launcher)));
        }


        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColors(new int[]{R.color.blue, R.color.green}, getContext());
        LineData lineData = new LineData(dataSet);
        return lineData;

    }


}
