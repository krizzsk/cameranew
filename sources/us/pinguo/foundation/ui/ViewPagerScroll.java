package us.pinguo.foundation.ui;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class ViewPagerScroll extends Scroller {
    private int a;

    public ViewPagerScroll(Context context) {
        super(context);
        this.a = 1200;
    }

    public void a(ViewPager viewPager) {
        try {
            Field declaredField = viewPager.getClass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(int i2) {
        this.a = i2;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, this.a);
    }

    public ViewPagerScroll(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.a = 1200;
    }
}
