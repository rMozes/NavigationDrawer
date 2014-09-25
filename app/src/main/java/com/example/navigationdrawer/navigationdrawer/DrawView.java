package com.example.navigationdrawer.navigationdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by RICHI on 2014.09.21..
 */
public class DrawView extends View {

    private Paint paint = new Paint();
    private Paint mCircle = new Paint();

    private Path path = new Path();

    private float mX, mY, mRadius;

    public DrawView(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(6f);

        mCircle.setColor(Color.BLUE);
        mCircle.setAlpha(0x0);
        mRadius = 30f;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mX = event.getX();
        mY = event.getY();

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(mX, mY);
                mCircle.setColor(Color.BLUE);
                mCircle.setAlpha(0x32);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(mX, mY);
                break;
            case MotionEvent.ACTION_UP:
                mCircle.setAlpha(0x0);
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        canvas.drawCircle(mX, mY, mRadius, mCircle);
    }
}
