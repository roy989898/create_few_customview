package hk.com.poming.fewcustomviewlibrary.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import hk.com.poming.fewcustomviewlibrary.R;


/**
 * Created by roy.leung on 30/1/2018.
 */

public class CircleWithRightSideTextView extends View {
    private final Paint textPaint1;
    private final Paint textPaint2;
    private final Paint textPaint3;
    private final Paint textPaint4;
    private Paint paint;
    private float intertwoTextSpace = 5;
    private String firstLineOftext = "Outstanding Balance";
    private String secondLineOfText = "$100,000";
    private String thirdLineOfText = "Credit Limit";
    private String fourthLineOfText = "$5000,000";

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


        textPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        int thirdLineTextColor = getResources().getColor(R.color.dark);
        float thirdLinetextSize = 15;
        textPaint3.setColor(thirdLineTextColor);
        textPaint3.setTextAlign(Paint.Align.CENTER);
        textPaint3.setTextSize(thirdLinetextSize);

        textPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        int fourthLineTextColor = getResources().getColor(R.color.dark);
        float fourthLinetextSize = 20;
        textPaint4.setColor(fourthLineTextColor);
        textPaint4.setTextAlign(Paint.Align.CENTER);
        textPaint4.setTextSize(fourthLinetextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = 120;
//        float heighA = 30;
        float storkWidth = 30;
        float left = 0 + storkWidth/2;
        float top = 0 + storkWidth/2;
        float right = left + radius * 2 + storkWidth/2;
        float bootom = top + radius * 2 + storkWidth/2;
        float cx = left + (right - left) / 2;
        float cy = top + (bootom - top) / 2;
        float bearPercentage = 80;
        Paint.FontMetrics fmForThirdLineOfText = textPaint3.getFontMetrics();
        float yoffset3 = -fmForThirdLineOfText.ascent + fmForThirdLineOfText.descent;


        Paint.FontMetrics fmForFourthLineText = textPaint4.getFontMetrics();
        float yoffest4 = -fmForFourthLineText.ascent + fmForFourthLineText.descent;


        float heighA = yoffset3 + yoffest4 + intertwoTextSpace;


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
//        float reftLeft = cx;
//        float reftRight = reftLeft + 300;

    /*    paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawRect(reftLeft, reftTOP, reftRight, reftBottom, paint);*/


//         draw two line of text at the right side


        float y3 = reftBottom + (-yoffset3 - intertwoTextSpace);
        float y4 = reftBottom;
        canvas.drawText(thirdLineOfText, cx + radius, y3 - fmForThirdLineOfText.descent, textPaint3);
        canvas.drawText(fourthLineOfText, cx + radius, y4 - fmForThirdLineOfText.descent, textPaint4);
//         draw two line of text at the right side

        //  draw two line of text at the center

        Paint.FontMetrics fmForFirstLineText = textPaint1.getFontMetrics();
        float yOffset1 = -fmForFirstLineText.ascent + fmForFirstLineText.descent;


        Paint.FontMetrics fmForSecondLineText = textPaint2.getFontMetrics();
        float yOffset2 = -fmForSecondLineText.ascent + fmForSecondLineText.descent;


        float totlaYOffset = yOffset1 + yOffset2 + intertwoTextSpace;
        float y1 = cy + (totlaYOffset / 2f - yOffset2 - intertwoTextSpace);
        float y2 = cy + totlaYOffset / 2f;
        canvas.drawText(firstLineOftext, cx, y1 - fmForFirstLineText.descent, textPaint1);
        canvas.drawText(secondLineOfText, cx, y2 - fmForSecondLineText.descent, textPaint2);

        //  calculate the xDegree from high A
//        sine@=(heighA/2)/radius


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
// TODO: 1/2/2018 miniWidth= longetsText+spaceinnter_text_stork+stork/2+stork/2+right_text_long3/4
        
        int miniWidth = 0;
        int miniHeight = 0;
        int measuredWidth = miniWidth + getPaddingLeft() + getPaddingRight();
        measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
        int noPaddingmeasureWidth = measuredWidth - (getPaddingLeft() + getPaddingRight());
        int noPaddingmeasureHeight = noPaddingmeasureWidth;
        int measuredHeight = noPaddingmeasureHeight + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(measuredWidth, measuredHeight);
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
