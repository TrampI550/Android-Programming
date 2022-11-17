package com.example.lab9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class HouseViewka extends View {
    Paint paint;
    Rect rect;
    public HouseViewka(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#00BFFF"));

        paint.setColor(Color.parseColor("#7CFC00"));
        rect.set(spToPx(0, this), spToPx(200, this), spToPx(370, this), spToPx(300, this));
        canvas.drawRect(rect, paint);

        paint.setColor(Color.parseColor("#CD853F"));
        rect.set(spToPx(100, this), spToPx(150, this), spToPx(250, this), spToPx(250, this));
        canvas.drawRect(rect, paint);

        paint.setColor(Color.parseColor("#B22222"));
        rect.set(spToPx(205, this), spToPx(100, this), spToPx(225, this), spToPx(150, this));
        canvas.drawRect(rect, paint);

        paint.setColor(Color.parseColor("#8B4513"));
        Path path = new Path();
        path.moveTo(spToPx(80, this), spToPx(150, this));
        path.lineTo(spToPx(175, this), spToPx(120, this));
        path.lineTo(spToPx(270, this), spToPx(150, this));
        path.lineTo(spToPx(80, this), spToPx(150, this));
        path.close();
        canvas.drawPath(path, paint);
    }

    public static int spToPx(float sp, HouseViewka context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}