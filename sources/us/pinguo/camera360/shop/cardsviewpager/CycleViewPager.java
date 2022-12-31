package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CycleViewPager extends ViewPager {
    private static final String c = CycleViewPager.class.getSimpleName();
    private g a;
    private List<ViewPager.OnPageChangeListener> b;

    /* loaded from: classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            CycleViewPager.this.dispatchOnScrollStateChanged(i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            CycleViewPager.this.dispatchOnPageScrolled(i2 % CycleViewPager.this.a.b(), f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            String str = CycleViewPager.c;
            us.pinguo.common.log.a.d(str, "onPageSelected=" + i2, new Object[0]);
            CycleViewPager.this.dispatchOnPageSelected(i2 % CycleViewPager.this.a.b());
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnPageScrolled(int i2, float f2, int i3) {
        List<ViewPager.OnPageChangeListener> list = this.b;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.b.get(i4);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnPageSelected(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.b;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.b.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnScrollStateChanged(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.b;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.b.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
    }

    private boolean f() {
        return this.a != null;
    }

    private int g(int i2, int i3, int i4) {
        int i5 = i2;
        do {
            if (i2 % i4 == i3) {
                i5 = i2;
            } else {
                i2--;
            }
            if (i2 < 0) {
                break;
            }
        } while (i2 != i5);
        return i5;
    }

    private int h(int i2, int i3, int i4) {
        int count = f() ? this.a.getCount() : 0;
        int i5 = i2;
        do {
            if (i2 % i4 == i3) {
                i5 = i2;
            } else {
                i2++;
            }
            if (i2 >= count) {
                break;
            }
        } while (i2 != i5);
        return i5;
    }

    private int j(int i2) {
        if (f()) {
            return g(this.a.getCount() / 2, i2, this.a.b());
        }
        return 0;
    }

    private int k(int i2) {
        int i3 = i();
        if (f()) {
            int b = i3 % this.a.b();
            if (i2 < b) {
                i3 = g(i3, i2, this.a.b());
            } else if (i2 != i3) {
                i3 = h(i3, i2, this.a.b());
            }
            us.pinguo.common.log.a.d(c, MessageFormat.format("originIndex={0},currentOriginIndex={1},result={2}", Integer.valueOf(i2), Integer.valueOf(b), Integer.valueOf(i3)), new Object[0]);
            return i3;
        }
        return i3;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        List<ViewPager.OnPageChangeListener> list = this.b;
        if (list != null) {
            list.clear();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        if (f()) {
            return super.getCurrentItem() % this.a.b();
        }
        return 0;
    }

    public int i() {
        return super.getCurrentItem();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.b;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void setAdapter(g gVar) {
        this.a = gVar;
        super.setAdapter((PagerAdapter) gVar);
        if (getOffscreenPageLimit() == 1 || !f()) {
            return;
        }
        this.a.e(getOffscreenPageLimit());
    }

    public void setCurrentItemForCenter(int i2) {
        setCurrentItem(j(i2));
    }

    public void setCurrentItemForNear(int i2) {
        setCurrentItem(k(i2));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOffscreenPageLimit(int i2) {
        if (i2 > 1) {
            i2 = 1;
        }
        super.setOffscreenPageLimit(i2);
        if (f()) {
            this.a.e(getOffscreenPageLimit());
        }
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.addOnPageChangeListener(new a());
    }

    public void setCurrentItemForCenter(int i2, boolean z) {
        setCurrentItem(j(i2), z);
    }

    public void setCurrentItemForNear(int i2, boolean z) {
        setCurrentItem(k(i2), z);
    }
}
