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
 * Created by pomingpo on 2018/1/28.
 */

public class CircleInsideHaveTextView1 extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int size = 150;

    public CircleInsideHaveTextView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float presentage = 95f;
        float formStartAngle = presentage / 100.0f * 360.0f;
        int storkWidth = 30;
        paint.setStyle(Paint.Style.FILL);

        int left = 20;
        int right = left + size;
        int top = 100;
        int bottom = top + size;


        paint.setColor(getResources().getColor(R.color.blue));
        RectF oval = new RectF(left, top, right, bottom);
        canvas.drawArc(oval, 275, -formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.gray));
        canvas.drawArc(oval, 275, 360 - formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.white));
        int cx = right + (left - right) / 2;
        int cy = top + (bottom - top) / 2;
        int radius = (right - left - storkWidth) / 2;
        canvas.drawCircle(cx, cy, radius, paint);

    }
}
