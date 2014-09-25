package com.example.navigationdrawer.navigationdrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by RICHI on 2014.09.21..
 */
public class CustomView extends View {

    private static final String TAG = "CustomView";

    private Paint paint;
    private boolean isOnTouch;
    private SparseArray<Point> mPoints;
    private int[] colors;

    public CustomView(Context context) {
        super(context);
        init();
    }
    //first change in GitHub

    public CustomView(Context context, AttributeSet set) {
        super(context, set);
    }

    public CustomView(Context context, AttributeSet set, int defStyleAttrib) {
        super(context, set, defStyleAttrib);
    }

    private void init() {
        paint = new Paint();
        colors = new int[] {Color.RED, Color.BLUE, Color.BLACK, Color.CYAN, Color.GREEN, Color.DKGRAY
                            ,Color.MAGENTA, Color.LTGRAY, Color.YELLOW};
        mPoints = new SparseArray<Point>();
        isOnTouch = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();
        int index = event.getActionIndex();
        int id = event.getPointerId(index);


        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                Point point = new Point();
                point.setX(event.getX(index));
                point.setY(event.getY(index));
                mPoints.put(id, point);
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL: {
                mPoints.remove(id);
                break;
            }
            case MotionEvent.ACTION_MOVE:
                int size = mPoints.size();
                for(int i = 0; i < size; i++) {
                    Point point1 = mPoints.get(event.getPointerId(i));
                    if(point1 != null) {
                        point1.setX(event.getX(i));
                        point1.setY(event.getY(i));
                    }
                }
                break;
        }
        isOnTouch = true;
        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isOnTouch) {
            int size = mPoints.size();
            for(int i = 0; i < size; i++) {
                Point point = mPoints.valueAt(i);
                paint.setColor(colors[i % 9]);
                paint.setAlpha(50);
                canvas.drawCircle(point.getX(), point.getY(), 80, paint);
            }
        }

        //isOnTouch = false;
    }
}
