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
 * Created by roy.leung on 30/1/2018.
 */

public class CircleWithRightSideTextView extends View {
    private Paint paint;

    public CircleWithRightSideTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = 120;
        float xDegree = 40;
        float startPoint = 20;
        paint.setStyle(Paint.Style.STROKE);
        float left = 0;
        float top = 0;
        float right = left + radius * 2;
        float bootom = top + radius * 2;
        RectF reft = new RectF(left, top, right, bootom);
        paint.setStrokeWidth(30);
        paint.setColor(getResources().getColor(R.color.blue));
        canvas.drawArc(reft, startPoint + xDegree, 360 - xDegree, false, paint);

    }
}
