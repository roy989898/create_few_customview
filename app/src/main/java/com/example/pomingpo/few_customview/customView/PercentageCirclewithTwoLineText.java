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


    private final Paint textPaint1;
    private final Paint textPaint2;
    private Paint paint;
    private float intertwoTextSpace = 10;
    String firstLineText = "10%";
    String secondLineText = "Very Good";
    private int interTextAndStorkSpace=100;
    private int storkWidth=20;
    private int noPaddingmeasureWidth;
    private int noPaddingmeasureHeight;

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
       int size = noPaddingmeasureWidth;
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
        canvas.drawText(firstLineText, cx, y1 - fmForFirstLineText.descent, textPaint1);
        canvas.drawText(secondLineText, cx, y2 - fmForSecondLineText.descent, textPaint2);


    /*    paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawCircle(cx, cy, 10, paint);*/


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

// calculate the min width= longerTextWidth+textInnerStorkSpace+storkWidth;
        Rect rect1 = new Rect();
        textPaint1.getTextBounds(firstLineText, 0, firstLineText.length(), rect1);
        float firstLineTextLong = rect1.right - rect1.left;

        Rect rect2 = new Rect();
        textPaint2.getTextBounds(secondLineText, 0, secondLineText.length(), rect2);
        float secondLioneTextLong = rect2.right - rect2.left;

        float longerTextLong = firstLineTextLong > secondLioneTextLong ? firstLineTextLong : secondLioneTextLong;


        int miniWidth = (int) (longerTextLong + interTextAndStorkSpace * 2 + storkWidth * 2);
        // claculate the miniHeight=text1Height+text2Height+textInnerSpace +storkWidth*2+textInnerStorkSpace
        Paint.FontMetrics fmForFirstLineText = textPaint1.getFontMetrics();
        float yOffset1 = -fmForFirstLineText.ascent + fmForFirstLineText.descent;
        Paint.FontMetrics fmForSecondLineText = textPaint2.getFontMetrics();
        float yOffset2 = -fmForSecondLineText.ascent + fmForSecondLineText.descent;
        float totalTextHeight = yOffset1 + yOffset2;
        int miniHeight = (int) (totalTextHeight + intertwoTextSpace + storkWidth * 2 + interTextAndStorkSpace * 2);

        miniWidth = miniWidth < miniHeight ? miniHeight : miniWidth;

        int measuredWidth = resolveSize(miniWidth, widthMeasureSpec);
        noPaddingmeasureWidth = measuredWidth - (getPaddingLeft() + getPaddingRight());
        noPaddingmeasureHeight = noPaddingmeasureWidth;
        int measuredHeight = noPaddingmeasureHeight + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(measuredWidth, measuredHeight);

    }
}
