package com.example.pomingpo.few_customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.pomingpo.few_customview.R;

/**
 * Created by roy.leung on 29/1/2018.
 */

public class PercentageCirclewithTwoLineText extends View {

    private final int size = 500;
    private Paint paint;

    public PercentageCirclewithTwoLineText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.gray_deep));
        float radius = size / 2;

        float cx = 0 + radius;
        float cy = 0 + radius;
        canvas.drawCircle(cx, cy, radius, paint);
//        draw arc
        paint.setColor(getResources().getColor(R.color.green));
        float left = cx - radius;
        float top = cy - radius;
        float right = cx + radius;
        float bottom = cy + radius;
        RectF retf = new RectF(left, top, right, bottom);
        float percentage = 40;
        canvas.drawArc(retf, -90, 360 * percentage / 100, true, paint);

        float storkWidth = 70;
        float shoadowWidth = 2;
        paint.setColor(getResources().getColor(R.color.shadow));
        canvas.drawCircle(cx, cy, radius - storkWidth + shoadowWidth, paint);

        paint.setColor(getResources().getColor(R.color.white));
        canvas.drawCircle(cx, cy, radius - storkWidth, paint);


    }
}
