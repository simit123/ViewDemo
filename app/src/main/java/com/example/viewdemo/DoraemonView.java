package com.example.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * canvas 画一个哆啦A梦
 */
public class DoraemonView extends View {


    private Paint mPaint;

    public DoraemonView(Context context) {
        this(context,null);
    }

    public DoraemonView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DoraemonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
        int mWidth = 300;
        int mHeight = 400;

        // 当布局参数设置为wrap_content时，设置默认值
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, mHeight);
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, mHeight);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        int height = getHeight() - paddingBottom - paddingBottom;//view的半径
        int with = getWidth() - paddingRight - paddingLeft;
        int radius = Math.min(with,height)/2;
        mPaint.setColor(0xff0997F7);
        int centerY = paddingTop+height/2;
        int centerX = paddingLeft+with/2;
        canvas.drawCircle(centerX,centerY,radius,mPaint);//据左和据上的padding的控制

        mPaint.setColor(Color.WHITE);
        RectF face = new RectF(centerX - radius + 40,centerY -radius + 180,centerX + radius -40,centerY + radius - 20);
        canvas.drawOval(face,mPaint);

        mPaint.setColor(Color.BLACK);
        //眼睛宽150 长 200
        RectF eyeLeft = new RectF(centerX -150,centerY -radius + 100,centerX,centerY -radius + 300);
        canvas.drawOval(eyeLeft,mPaint);
        //眼睛宽150 长 200
        RectF eyeRight = new RectF(centerX,centerY -radius + 100,centerX + 150,centerY -radius + 300);
        canvas.drawOval(eyeRight,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawOval(new RectF(centerX -145,centerY -radius + 105,centerX-5,centerY -radius + 295),mPaint);
        canvas.drawOval(new RectF(centerX+5,centerY -radius + 105,centerX + 145,centerY -radius + 295),mPaint);


        //画眼球
        mPaint.setColor(Color.BLACK);
        canvas.drawOval(new RectF(centerX -50,centerY -radius + 180,centerX - 10,centerY - radius + 250),mPaint);
        canvas.drawOval(new RectF(centerX + 50,centerY -radius + 180,centerX + 10,centerY - radius + 250),mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawOval(new RectF(centerX -40,centerY -radius + 200,centerX - 20,centerY - radius + 230),mPaint);
        canvas.drawOval(new RectF(centerX + 40,centerY -radius + 200,centerX + 20,centerY - radius + 230),mPaint);

        mPaint.setColor(0xffD52B2B);
        canvas.drawCircle(centerX,centerY - 145,40,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        canvas.drawLine(centerX,centerY - 105,centerX,centerY + 120,mPaint);

//        canvas.drawArc(centerX - 300,centerY - 120,centerX + 300,centerY + 350,0,180,false,mPaint);
        //嘴巴
        mPaint.setColor(0xffCC3333);
        canvas.drawArc(centerX - 295,centerY - 150,centerX + 295,centerY + 400,0,180,false,mPaint);

        //胡子
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        canvas.drawLine(centerX - 80,centerY - 20,centerX - 280,centerY - 20,mPaint);
        canvas.drawLine(centerX - 80,centerY - 40,centerX - 280,centerY - 80,mPaint);
        canvas.drawLine(centerX - 80,centerY,centerX - 280,centerY + 40,mPaint);

        canvas.drawLine(centerX + 80,centerY - 20,centerX + 280,centerY - 20,mPaint);
        canvas.drawLine(centerX + 80,centerY - 40,centerX + 280,centerY - 80,mPaint);
        canvas.drawLine(centerX + 80,centerY,centerX + 280,centerY + 40,mPaint);
    }
}
