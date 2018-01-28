package com.example.pomingpo.few_customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pomingpo.few_customview.customView.CircleInsideHaveTextView1;

public class MainActivity extends AppCompatActivity {

    private CircleInsideHaveTextView1 cv1r;
    private Button btchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btchange = (Button) findViewById(R.id.bt_change);
        this.cv1r = (CircleInsideHaveTextView1) findViewById(R.id.cv1_r);


        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv1r.setPresentage(randomWithRange(0, 100));
            }
        });


    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
