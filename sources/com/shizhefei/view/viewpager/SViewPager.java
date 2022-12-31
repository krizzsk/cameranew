package com.shizhefei.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class SViewPager extends ViewPager {
    private boolean a;

    public SViewPager(Context context) {
        super(context);
        this.a = false;
    }

    public boolean a() {
        return this.a;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCanScroll(boolean z) {
        this.a = z;
    }

    public SViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }
}
