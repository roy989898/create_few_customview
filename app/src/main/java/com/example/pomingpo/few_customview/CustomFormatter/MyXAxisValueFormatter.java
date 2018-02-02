package com.example.pomingpo.few_customview.CustomFormatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roy.leung on 2/2/2018.
 */

public class MyXAxisValueFormatter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        Date dNow = new Date((long) value);
        SimpleDateFormat ft =
                new SimpleDateFormat("MMMyyyy");


        return ft.format(dNow);
    }

}
