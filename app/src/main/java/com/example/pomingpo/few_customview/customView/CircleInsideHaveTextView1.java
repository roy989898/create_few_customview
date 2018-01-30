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
 * Created by pomingpo on 2018/1/28.
 */

public class CircleInsideHaveTextView1 extends View {

    private final int storkColor;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String textToShow;
    private final String defaultFirstLineP = "100.00%";
    private int noPaddingmeasureWidth;
    private int noPaddingmeasureHeight;
    private float presentage;
    private float storkWidth;
    private float innerTextSize;

    public CircleInsideHaveTextView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircleInsideHaveTextView1,
                0, 0);

        try {
            presentage = a.getFloat(R.styleable.CircleInsideHaveTextView1_percentage, 0);
            storkWidth = a.getDimension(R.styleable.CircleInsideHaveTextView1_storkWidth, 30);
            innerTextSize = a.getDimension(R.styleable.CircleInsideHaveTextView1_innerTextSize, 20);
            storkColor = a.getInteger(R.styleable.CircleInsideHaveTextView1_storkColor, 0);
        } finally {
            a.recycle();
        }


        textPaint.setColor(getResources().getColor(R.color.dark));
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(innerTextSize);

    }

    public float getPresentage() {
        return presentage;
    }

    public void setPresentage(float presentage) {
        this.presentage = presentage;
//        requestLayout();
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        textToShow = presentage + "%";

        float formStartAngle = presentage / 100.0f * 360.0f;

        paint.setStyle(Paint.Style.FILL);

        int size = noPaddingmeasureWidth;
        int left = 0;
        int right = left + size;
        int top = 0;
        int bottom = top + size;


        paint.setColor(storkColor);
        RectF oval = new RectF(left, top, right, bottom);
        canvas.drawArc(oval, 275, -formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.gray));
        canvas.drawArc(oval, 275, 360 - formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.white));
        float cx = right + (left - right) / 2f;
        float cy = top + (bottom - top) / 2f;
        float radius = (right - left - storkWidth * 2) / 2f;
        canvas.drawCircle(cx, cy, radius, paint);


        Rect result = new Rect();
        textPaint.getTextBounds(textToShow, 0, textToShow.length(), result);
        float yOffset = result.bottom - result.top / 2f;
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        canvas.drawText(textToShow, cx, cy + yOffset - fm.descent, textPaint);


   /*     float x = fm.descent;
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        result.top += cy - x;
        result.bottom += cy - x;
        result.right += cx;
        result.left += cx;
        canvas.drawRect(result, paint);*/
 /*       paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawCircle(cx, cy, 5, paint);*/

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // calculate the min size= text_long+space+storkWidth*2
        Rect result = new Rect();
        textPaint.getTextBounds(defaultFirstLineP, 0, defaultFirstLineP.length(), result);
        float textLongSize = result.right - result.left;
        float spaceBetweenTextAndStork = 10;
        int miniSize = (int) (textLongSize + spaceBetweenTextAndStork + storkWidth * 2);


        int measuredWidth = miniSize + getPaddingLeft() + getPaddingRight();
        measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
        noPaddingmeasureWidth = measuredWidth - (getPaddingLeft() + getPaddingRight());
        noPaddingmeasureHeight = noPaddingmeasureWidth;
        int measuredHeight = noPaddingmeasureHeight + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
