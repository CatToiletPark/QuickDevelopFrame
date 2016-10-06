package com.easygo.framework.ui.widget.recylcerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * description :
 *
 * @author by lyh on 2016/10/6 15:17.
 */

public class EasyGoRecyclerDivider extends RecyclerView.ItemDecoration {

    /*
	 * RecyclerView的布局方向，默认先赋值 为纵向布局 RecyclerView 布局可横向，也可纵向 横向和纵向对应的分割线画法不一样
	 */
    private int mOrientation = LinearLayoutManager.VERTICAL;

    /**
     * item之间分割线的size，默认为8 google material desgin card 默认留白 移动设备上的卡片间距
     *
     * 屏幕边界与卡片间留白：8 dp
     *
     * 卡片间留白：8 dp
     *
     * 内容留白
     *
     * 16 dp
     */
    private int mItemSize = 8;

    /**
     * 绘制item分割线的画笔，和设置其属性 来绘制个性分割线
     */
    private Paint mPaint;

    /**
     * 分割线颜色
     */
    private int mColor = Color.TRANSPARENT;

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param orientation 布局方向 默认为水平
     */
    public EasyGoRecyclerDivider(Context context, int orientation) {
        this(context, orientation, 0, Color.TRANSPARENT);
    }

    /**
     *  构造方法，默认为水平
     * @param context 上下文
     * @param orientation 布局方向 默认为水平
     * @param diverSize 分割线大小
     * @param diverColor 分割线颜色
     */
    public EasyGoRecyclerDivider(Context context, int orientation, int diverSize, int diverColor) {
        this.mOrientation = orientation;
        if (0 != diverSize) {
            this.mItemSize = diverSize;
        }
        if (diverColor != Color.TRANSPARENT) {
            mColor = diverColor;
        }
        if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("请传入正确的参数");
        }
//		mItemSize = SizeFormatControl.getdiptopx(context, mItemSize);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(mItemSize);
        mPaint.setColor(mColor);
		/* 设置填充 */
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    /**
     * 绘制纵向 item 分割线
     *
     * @param canvas
     * @param parent
     */
    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            // RecyclerView.LayoutParams layoutParams =
            // (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getTop() + mItemSize;
            int bottom = top + child.getMeasuredHeight();
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    /**
     * 绘制横向 item 分割线
     *
     * @param canvas
     * @param parent
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mItemSize;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    /**
     * 设置item分割线的size
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        // GridLayoutManager
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            int spanCount = gridLayoutManager.getSpanCount();
            if (position / spanCount < 1) {
                outRect.set(mItemSize, mItemSize, mItemSize, mItemSize);
            } else {
                outRect.set(mItemSize, 0, mItemSize, mItemSize);
            }
        }
        // LinearLayoutManager
        else {
            if (mOrientation == LinearLayoutManager.VERTICAL) {

                if (0 == position)
                    outRect.set(0, mItemSize, 0, mItemSize);
                else
                    outRect.set(0, 0, 0, mItemSize);
            } else {
                outRect.set(0, 0, mItemSize, 0);
            }
        }
    }

}
