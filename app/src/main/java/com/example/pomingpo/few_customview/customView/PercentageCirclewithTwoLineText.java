package com.example.pomingpo.few_customview.customView;

import android.content.Context;
import android.content.res.TypedArray;
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
    private final int firstLineTextColor;
    private final int secondLineTextColor;
    private String longestSecondLineText = "";
    private Paint paint;
    private float intertwoTextSpace = 10;
    private float firstLineTextSize = 200;
    private float secondLinetextSize = 30;
    String firstLineText = "10%";
    String secondLineText = "Very Good";
    private int noPaddingMeasuredWidth;
    private int noPaddingmeasureHeight;
    private float spaceInnerTextAndStork = 30;
    private float storkWidth = 70;
    private float percentage;
    private final String defaultFirstLineP = "100.00%";

    public void setPercentage(float percentage) {
        this.percentage = percentage;
        invalidate();

    }

    public PercentageCirclewithTwoLineText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PercentageCirclewithTwoLineText,
                0, 0);

        try {
            percentage = a.getFloat(R.styleable.PercentageCirclewithTwoLineText_pc_percentage, 10);
            firstLineTextColor = a.getColor(R.styleable.PercentageCirclewithTwoLineText_pc_first_line_color, getResources().getColor(R.color.dark));
            firstLineTextSize = a.getDimension(R.styleable.PercentageCirclewithTwoLineText_pc_first_line_text_size, 20);

            secondLineTextColor = a.getColor(R.styleable.PercentageCirclewithTwoLineText_pc_second_line_color, getResources().getColor(R.color.dark));
            secondLinetextSize = a.getDimension(R.styleable.PercentageCirclewithTwoLineText_pc_second_line_text_size, 20);
            secondLineText = a.getString(R.styleable.PercentageCirclewithTwoLineText_pc_second_line_text);
            longestSecondLineText = a.getString(R.styleable.PercentageCirclewithTwoLineText_pc_longest_second_line_text);
            if (secondLineText == null) {
                secondLineText = "";
            }
            if (longestSecondLineText == null) {
                longestSecondLineText = "";
            }

        } finally {
            a.recycle();
        }

//        spaceInnerTextAndStork= (float) ((firstLineTextSize>secondLinetextSize?firstLineTextSize:secondLinetextSize)*0.3);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint1.setTextAlign(Paint.Align.CENTER);
        textPaint1.setColor(firstLineTextColor);
        textPaint1.setTextSize(firstLineTextSize);

        textPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint2.setColor(secondLineTextColor);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint2.setTextSize(secondLinetextSize);
    }

    private void setText() {

        firstLineText = percentage + "%";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = noPaddingMeasuredWidth;
        setText();


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

        canvas.drawArc(retf, -90, 360 * percentage / 100, true, paint);


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

        // miniWidgth=longer_text_width+space_innter_text_and_stork*2+stork_width *2
        setText();

        int firstLineTextWidth = calculatetextWidth(textPaint1, defaultFirstLineP);
        int secondLineTextWidth = calculatetextWidth(textPaint2, longestSecondLineText);
        int longerTextWidth = firstLineTextWidth > secondLineTextWidth ? firstLineTextWidth : secondLineTextWidth;

        float miniwidth = longerTextWidth + spaceInnerTextAndStork * 2 + storkWidth * 2;

//  calculate the mini height =two_line_text_height+innte_text_space+space_innter_text_and_stork*2+stork_width *2

        float totalTextHeight = calculateTextHeight(textPaint2) + calculateTextHeight(textPaint1);

        float miniHeight = totalTextHeight + intertwoTextSpace + spaceInnerTextAndStork * 2 + storkWidth * 2;

        miniwidth = miniwidth > miniHeight ? miniwidth : miniHeight;

        float miniwidthWithPadding = miniwidth + getPaddingLeft() + getPaddingRight();
        int measuredWidth = resolveSize((int) miniwidthWithPadding, widthMeasureSpec);
        int newNoPaddingMeasuredWidth = measuredWidth - (getPaddingLeft() + getPaddingRight());
        noPaddingMeasuredWidth = newNoPaddingMeasuredWidth > noPaddingMeasuredWidth ? newNoPaddingMeasuredWidth : noPaddingMeasuredWidth;
        noPaddingmeasureHeight = noPaddingMeasuredWidth;
        int measuredHeight = noPaddingmeasureHeight + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private int calculatetextWidth(Paint paint, String text) {

        Rect rect1 = new Rect();

        paint.getTextBounds(text, 0, text.length(), rect1);

        int textWidth = rect1.right - rect1.left;


        return textWidth;
    }

    private float calculateTextHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        float textHeight = -fm.ascent + fm.descent;

        return textHeight;
    }
}
