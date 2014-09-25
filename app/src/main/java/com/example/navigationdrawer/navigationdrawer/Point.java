package com.example.navigationdrawer.navigationdrawer;

/**
 * Created by RICHI on 2014.09.22..
 */
public class Point {

    private float mX, mY;

    public Point(){

    }

    public Point(float x, float y) {
        this.mX = x;
        this.mY = y;
    }

    public float getY() {
        return mY;
    }

    public void setY(float mY) {
        this.mY = mY;
    }

    public float getX() {
        return mX;
    }

    public void setX(float mX) {
        this.mX = mX;
    }
}
