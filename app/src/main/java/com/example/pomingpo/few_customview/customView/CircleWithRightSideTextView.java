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
    private final Paint textPaint1;
    private final Paint textPaint2;
    private Paint paint;
    private float intertwoTextSpace=5;

    public CircleWithRightSideTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        textPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1.setTextAlign(Paint.Align.CENTER);
        int firstLineTextColor = getResources().getColor(R.color.gray_deep);
        float firstLineTextSize = 25;
        textPaint1.setColor(firstLineTextColor);
        textPaint1.setTextSize(firstLineTextSize);

        textPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        int secondLineTextColor = getResources().getColor(R.color.blue);
        float secondLinetextSize = 50;
        textPaint2.setColor(secondLineTextColor);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint2.setTextSize(secondLinetextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = 120;
        float heighA = 30;
        float storkWidth = 30;
        float left = 0 + storkWidth;
        float top = 0 + storkWidth;
        float right = left + radius * 2 + storkWidth;
        float bootom = top + radius * 2 + storkWidth;
        float cx = left + (right - left) / 2;
        float cy = top + (bootom - top) / 2;
        float bearPercentage = 80;

        // TODO: 31/1/2018 draw two line of text at the center
        String firstLineOftext = "Outstanding Balance";
        String secondLineOfText = "$100,000";

        //        Rect rect1 = new Rect();

//        textPaint1.getTextBounds(firstLineText, 0, firstLineText.length(), rect1);
        Paint.FontMetrics fmForFirstLineText = textPaint1.getFontMetrics();
        float yOffset1 = -fmForFirstLineText.ascent + fmForFirstLineText.descent;


//        Rect rect2 = new Rect();

//        textPaint2.getTextBounds(secondLineText, 0, secondLineText.length(), rect2);
        Paint.FontMetrics fmForSecondLineText = textPaint2.getFontMetrics();
        float yOffset2 = -fmForSecondLineText.ascent + fmForSecondLineText.descent;


        float totlaYOffset = yOffset1 + yOffset2 + intertwoTextSpace;
        float y1 = cy + (totlaYOffset / 2f - yOffset2 - intertwoTextSpace);
        float y2 = cy + totlaYOffset / 2f;
        canvas.drawText(firstLineOftext, cx, y1 - fmForFirstLineText.descent, textPaint1);
        canvas.drawText(secondLineOfText, cx, y2 - fmForSecondLineText.descent, textPaint2);

        //  calculate the xDegree from high A
//        sine@=(heighA/2)/radius
        float xDegree = useHeightToCalcuateTheDegree(heighA, radius);
//        float xDegree = 40;
        float startPoint = 20;
        paint.setStyle(Paint.Style.STROKE);


        RectF reft = new RectF(left, top, right, bootom);
        paint.setStrokeWidth(storkWidth);
        paint.setColor(getResources().getColor(R.color.gray_deep));
        canvas.drawArc(reft, startPoint + xDegree, 360 - xDegree, false, paint);

        float resultDegree = bearPercentage / 100 * (360 - xDegree);
        paint.setColor(getResources().getColor(R.color.blue));
        canvas.drawArc(reft, startPoint + xDegree, resultDegree, false, paint);


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
