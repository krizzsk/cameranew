package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
/* loaded from: classes9.dex */
public class FixbugViewPager extends VerticalViewPager {
    public FixbugViewPager(Context context) {
        super(context);
    }

    @Override // fr.castorflex.android.verticalviewpager.VerticalViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public FixbugViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
