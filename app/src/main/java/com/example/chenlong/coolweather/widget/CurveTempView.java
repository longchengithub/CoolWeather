package com.example.chenlong.coolweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.example.chenlong.coolweather.util.DisplayUtil;

import java.util.ArrayList;

/**
 * Created by ChenLong on 2017/2/1.
 */

public class CurveTempView extends View
{
    private Context mContext;
    private int mWidth;
    private int mHeight;
    private int mVerMargin; //Y轴距离底部
    private int mHorMargin; //X轴偏移
    private Paint mPaint;

    /**
     * 温度数据
     */
    private int[] temp;
    private String[] tempText;
    private int tempMargin;
    private int middleTemp;


    public void setTemp(int[] temp)
    {
        this.temp = temp;
    }

    public void setTempText(String[] tempText)
    {
        this.tempText = tempText;
    }

    /**
     * 自变量坐标集合
     */
    private ArrayList<Integer> xPoints;
    /**
     * 坐标点集合
     */
    private Point[] points;

    /**
     * 构造方法
     *
     * @param context
     */
    public CurveTempView(Context context)
    {
        this(context, null);
    }

    public CurveTempView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CurveTempView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = measureWidth(widthMeasureSpec);
        mHeight = measureHeight(heightMeasureSpec);

        setMeasuredDimension(mWidth, mHeight);

        initView();
    }

    private void initView()
    {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mVerMargin = DisplayUtil.dp2px(mContext, 50);
        mHorMargin = DisplayUtil.dp2px(mContext, 8);
        tempMargin = DisplayUtil.dp2px(mContext, 75);
    }

    /**
     * 测量最终的高
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec)
    {
        int result = 0;

        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);

        switch (mode)
        {
            case MeasureSpec.EXACTLY:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                result = getMeasuredHeight();
                break;
        }

        return result;
    }

    /**
     * 测量最终的宽
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec)
    {
        return MeasureSpec.getSize(widthMeasureSpec);
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        if (temp == null || temp.length < 0)
        {
            return;
        }
        drawGraphAxis(canvas);
        drawXValue(canvas);
        drawYValue(canvas);
        drawPoints(canvas);
    }

    /**
     * 绘制圆点
     *
     * @param canvas
     */
    private void drawPoints(Canvas canvas)
    {
        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < points.length; i++)
        {
            mPaint.setColor(Color.BLUE);
            canvas.drawCircle(points[i].x, points[i].y, DisplayUtil.dp2px(mContext, 3), mPaint);
            mPaint.setColor(Color.BLACK);
            canvas.drawText(temp[i] + "℃", points[i].x, points[i].y - DisplayUtil.dp2px(mContext, 8), mPaint);
        }
    }

    private void drawYValue(Canvas canvas)
    {
        int maxTemp = temp[0], minTemp = temp[0];
        for (int i : temp)
        {
            maxTemp = i > maxTemp ? i : maxTemp;
            minTemp = i < minTemp ? i : minTemp;
        }

        middleTemp = (Math.abs(maxTemp) + Math.abs(minTemp)) / 2;   //平均的温度
        int middleY = (mHeight - mVerMargin) / 2;                   //绘制区域的中间的Y轴
        int piece = (middleY - tempMargin) / middleTemp;            //与平均的温度差异时 每度偏差的y值
        points = getAllPoints(xPoints, middleTemp, middleY, piece);

        mPaint.setStrokeWidth(DisplayUtil.dp2px(mContext, 2));
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < points.length - 1; i++)
        {
            canvas.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y, mPaint);
        }
    }

    /**
     * 所有的x ,y轴
     *
     * @param xPoints
     * @param middleTemp 平均温度
     * @param middleY    平均y值
     * @param piece      差异值
     * @return
     */
    private Point[] getAllPoints(ArrayList<Integer> xPoints, int middleTemp, int middleY, int piece)
    {
        points = new Point[temp.length];
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] == middleTemp)
            {
                points[i] = new Point(xPoints.get(i), middleY);
            } else if ((temp[i] - middleTemp) > 0)      //大于平均温度 y值向上移动 就是减法
            {
                points[i] = new Point(xPoints.get(i), middleY - (temp[i] - middleTemp) * piece);
            } else if ((temp[i] - middleTemp) < 0)      //小于平均温度,y值向下移动 就是加法
            {
                points[i] = new Point(xPoints.get(i), middleY - (temp[i] - middleTemp) * piece);
            }

        }
        return points;
    }

    /**
     * 绘制底部的线下的文字
     *
     * @param canvas
     */
    private void drawXValue(Canvas canvas)
    {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(0);
        mPaint.setTextSize(DisplayUtil.dp2px(mContext, 12));
        mPaint.setTextAlign(Paint.Align.LEFT);

        int jiange = DisplayUtil.dp2px(mContext, 60);

        xPoints = new ArrayList<>();

        int Xstart = 0;        //起始的X值.
        int YHeight = mHeight - mVerMargin / 2;
        for (String s : tempText)
        {
            xPoints.add(Xstart + mHorMargin);    //添加所有的x坐标
            canvas.drawText(s, Xstart, YHeight, mPaint);
            Xstart += jiange;
        }
    }

    /**
     * 绘制底部的一条线
     *
     * @param canvas
     */
    private void drawGraphAxis(Canvas canvas)
    {
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(DisplayUtil.dp2px(mContext, 2));
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0 + mHorMargin, mHeight - mVerMargin, mWidth - mHorMargin, mHeight - mVerMargin, mPaint);
    }
}
