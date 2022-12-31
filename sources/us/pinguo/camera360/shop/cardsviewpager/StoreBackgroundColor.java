package us.pinguo.camera360.shop.cardsviewpager;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tapjoy.TJAdUnitConstants;
/* loaded from: classes3.dex */
public class StoreBackgroundColor extends View implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    ValueAnimator a;
    private b b;

    /* loaded from: classes3.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private int a;

        private b() {
        }

        public int a() {
            return this.a;
        }

        public void b(int i2) {
            this.a = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int a = a() - 1;
            if (a < 4) {
                a = 6;
            }
            if (a != 0) {
                StoreBackgroundColor.this.c((int) (((i2 + f2) / a) * 3000.0f));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    public StoreBackgroundColor(Context context) {
        this(context, null, 0);
    }

    private void b() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, TJAdUnitConstants.String.BACKGROUND_COLOR, -11940957, -359899, -1656787, -1219755, -8357692, -11233834);
        this.a = ofInt;
        ofInt.setEvaluator(new ArgbEvaluator());
        this.a.setDuration(3000L);
        this.a.addUpdateListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        if (this.a == null) {
            b();
        }
        this.a.setCurrentPlayTime(j2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        invalidate();
    }

    public void setmViewPager(ViewPager viewPager, int i2) {
        if (viewPager.getAdapter() != null) {
            this.b.b(i2);
            viewPager.addOnPageChangeListener(this.b);
            b();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public StoreBackgroundColor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreBackgroundColor(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.b = new b();
    }
}
