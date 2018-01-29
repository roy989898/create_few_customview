package com.example.pomingpo.few_customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private final Paint textPaint1;
    private final Paint textPaint2;
    private Paint paint;

    public PercentageCirclewithTwoLineText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1.setTextAlign(Paint.Align.CENTER);
        textPaint1.setColor(getResources().getColor(R.color.first_lineText_color));
        textPaint1.setTextSize(80);
        textPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint2.setColor(getResources().getColor(R.color.second_lineText_color));
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint2.setTextSize(30);
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

        Rect rect1 = new Rect();
        String firstLineText = "10%";
        textPaint1.getTextBounds(firstLineText, 0, firstLineText.length(), rect1);
        float yOffset1 = rect1.bottom - rect1.top / 2f;
        Paint.FontMetrics fmForFirstLineText = textPaint1.getFontMetrics();
        canvas.drawText(firstLineText, cx, cy + yOffset1 - fmForFirstLineText.descent, textPaint1);


        Rect rect2 = new Rect();
        String secondLineText = "Very Good";
        textPaint2.getTextBounds(secondLineText, 0, secondLineText.length(), rect2);
        float yOffset2 = rect2.bottom - rect2.top / 2f;
        Paint.FontMetrics fmForSecondLineText = textPaint2.getFontMetrics();
        canvas.drawText(secondLineText, cx, cy + yOffset2 - fmForSecondLineText.descent, textPaint2);


    }
}
