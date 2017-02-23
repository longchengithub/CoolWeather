package com.example.chenlong.coolweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.chenlong.coolweather.util.DisplayUtil;

/**
 * Created by ChenLong on 2017/2/5.
 */

public class ArcProgressBarView extends View
{
    private Paint mPaint;
    private Context mContext;

    public ArcProgressBarView(Context context)
    {
        this(context, null);
    }

    public ArcProgressBarView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public ArcProgressBarView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);  //开启抗锯齿
        mPaint.setColor(Color.GRAY); //画笔颜色
        mPaint.setStrokeWidth(8);   //画笔线宽
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        RectF rectF = new RectF(10, 10, 300, 300);

        canvas.drawArc(rectF, 150, 240, false, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(7);
        canvas.drawArc(rectF,150,56,false,mPaint);

        mPaint.setStrokeWidth(0);
        mPaint.setTextSize(DisplayUtil.dp2px(mContext,30));
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("76",150,180,mPaint);

        mPaint.setTextSize(DisplayUtil.dp2px(mContext,8));
        mPaint.setColor(Color.GRAY);
        canvas.drawText("AQI指数",150,224,mPaint);


    }
}
