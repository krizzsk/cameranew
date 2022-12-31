package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes9.dex */
class MTabViewPager extends ViewPager {
    private ViewParent a;

    public MTabViewPager(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            ViewParent viewParent = null;
            while (true) {
                viewParent = viewParent != null ? viewParent.getParent() : getParent();
                if (viewParent == null) {
                    break;
                } else if (viewParent instanceof ViewPager) {
                    this.a = viewParent;
                    break;
                }
            }
        }
        ViewParent viewParent2 = this.a;
        if (viewParent2 != null) {
            viewParent2.requestDisallowInterceptTouchEvent(true);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public MTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
