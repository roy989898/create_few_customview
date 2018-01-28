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
 * Created by pomingpo on 2018/1/28.
 */

public class CircleInsideHaveTextView1 extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int size = 150;
    private int noPaddingmeasureWidth;
    private int noPaddingmeasureHeight;

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

        size = noPaddingmeasureWidth;
        int left = 0;
        int right = left + size;
        int top = 0;
        int bottom = top + size;


        paint.setColor(getResources().getColor(R.color.blue));
        RectF oval = new RectF(left, top, right, bottom);
        canvas.drawArc(oval, 275, -formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.gray));
        canvas.drawArc(oval, 275, 360 - formStartAngle, true, paint);


        paint.setColor(getResources().getColor(R.color.white));
        float cx = right + (left - right) / 2f;
        float cy = top + (bottom - top) / 2f;
        int radius = (right - left - storkWidth) / 2;
        canvas.drawCircle(cx, cy, radius, paint);


        String textToShow = presentage + "%";
        paint.setColor(getResources().getColor(R.color.dark));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(25);
        Rect result = new Rect();
        paint.getTextBounds(textToShow, 0, textToShow.length(), result);
        float yOffset = result.bottom - result.top / 2f;
        Paint.FontMetrics fm = paint.getFontMetrics();
        canvas.drawText(textToShow, cx, cy + yOffset - fm.descent, paint);


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

        int miniSize = 100;
        int measuredWidth = miniSize + getPaddingLeft() + getPaddingRight();
        measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
        noPaddingmeasureWidth = measuredWidth - (getPaddingLeft() + getPaddingRight());
        noPaddingmeasureHeight = noPaddingmeasureWidth;
        int measuredHeight = noPaddingmeasureHeight + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
