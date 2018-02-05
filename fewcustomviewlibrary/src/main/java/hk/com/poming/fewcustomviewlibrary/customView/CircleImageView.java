package hk.com.poming.fewcustomviewlibrary.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import hk.com.poming.fewcustomviewlibrary.R;

/**
 * Created by roy.leung on 5/2/2018.
 */

public class CircleImageView extends ImageView {
    private final Paint paint;
    private int radius;

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        paint.setColor(getResources().getColor(R.color.blue));
        float x = 0;
        float y = 0;

        float cx = x + radius;
        float cy = y + radius;
        Path path = new Path();
        path.addCircle(cx, cy, radius, Path.Direction.CCW);
        canvas.clipPath(path);
        super.onDraw(canvas);
        canvas.restore();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        radius = (measuredWidth > measuredHeight) ? measuredHeight / 2 : measuredWidth / 2;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
