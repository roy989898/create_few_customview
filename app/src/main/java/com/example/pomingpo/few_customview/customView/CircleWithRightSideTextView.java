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
        float heighA = 30;
        float storkWidth = 30;
        // TODO: 30/1/2018 calculate the xDegree from high A

//        sine@=(heighA/2)/radius
        float xDegree = useHeightToCalcuateTheDegree(heighA, radius);
//        float xDegree = 40;
        float startPoint = 20;
        paint.setStyle(Paint.Style.STROKE);
        float left = 0 + storkWidth;
        float top = 0 + storkWidth;
        float right = left + radius * 2 + storkWidth;
        float bootom = top + radius * 2 + storkWidth;
        float cx = left + (right - left) / 2;
        float cy = top + (bootom - top) / 2;


        RectF reft = new RectF(left, top, right, bootom);
        paint.setStrokeWidth(storkWidth);
        paint.setColor(getResources().getColor(R.color.blue));
        canvas.drawArc(reft, startPoint + xDegree, 360 - xDegree, false, paint);


        float reftTOP = cy + useDegreeToCalculateTheHeight(startPoint, radius);
        float reftBottom = reftTOP + heighA;
        //        temp
        float reftLeft = cx;
//        temp
        float reftRight = reftLeft + 300;


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawRect(reftLeft, reftTOP, reftRight, reftBottom, paint);


    }


    private float useHeightToCalcuateTheDegree(float height, float radius) {
        double d = Math.asin((height / 2) / radius);
        float xDegree = (float) Math.toDegrees(d) * 2;

        return xDegree * 1.25f;
    }

    private float useDegreeToCalculateTheHeight(float degree, float radius) {

        return (float) (Math.tan(Math.toRadians(degree)) * radius);
    }
}
