package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.growingio.android.sdk.autoburry.VdsAgent;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes3.dex */
public class DimFrameLayout extends FrameLayout {
    private Scroller a;
    private Interpolator b;
    private Rect c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            DimFrameLayout dimFrameLayout = DimFrameLayout.this;
            dimFrameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(dimFrameLayout, 4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public DimFrameLayout(Context context) {
        super(context);
        this.c = new Rect();
        b(context);
    }

    private void b(Context context) {
        this.b = new LinearInterpolator();
        this.a = new Scroller(context, this.b);
    }

    public void a(boolean z) {
        if (getVisibility() == 4) {
            return;
        }
        if (z) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, childAt.getHeight());
                translateAnimation.setDuration(300L);
                translateAnimation.setInterpolator(this.b);
                translateAnimation.setAnimationListener(new a());
                childAt.startAnimation(translateAnimation);
                this.a.startScroll(128, 0, -128, 0, IjkMediaCodecInfo.RANK_SECURE);
                return;
            }
            super.setVisibility(4);
            VdsAgent.onSetViewVisibility(this, 4);
            setBackgroundDrawable(null);
            return;
        }
        super.setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        setBackgroundDrawable(null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("DimFrameLayout can host only one direct child");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.a.computeScrollOffset()) {
            setBackgroundColor(this.a.getCurrX() << 24);
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.c.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            this.c.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = !this.c.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && z && this.a.isFinished()) {
            a(true);
        }
        return z;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
    }

    public DimFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        b(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("DimFrameLayout can host only one direct child");
    }

    public DimFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new Rect();
        b(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, i3);
            return;
        }
        throw new IllegalStateException("DimFrameLayout can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("DimFrameLayout can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("DimFrameLayout can host only one direct child");
    }
}
