package us.pinguo.camera360.shop.cardsviewpager;

import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;
/* compiled from: CycleViewPagerIndicatorHelper.java */
/* loaded from: classes3.dex */
public class h {

    /* compiled from: CycleViewPagerIndicatorHelper.java */
    /* loaded from: classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        final /* synthetic */ MagicIndicator a;

        a(MagicIndicator magicIndicator) {
            this.a = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.a.a(i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            this.a.b(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            this.a.c(i2);
        }
    }

    public static void a(MagicIndicator magicIndicator, CycleViewPager cycleViewPager) {
        cycleViewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}
