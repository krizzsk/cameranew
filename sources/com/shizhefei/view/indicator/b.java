package com.shizhefei.view.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.shizhefei.view.indicator.a;
import com.shizhefei.view.viewpager.SViewPager;
/* compiled from: IndicatorViewPager.java */
/* loaded from: classes3.dex */
public class b {
    protected com.shizhefei.view.indicator.a a;
    protected ViewPager b;
    protected f c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7154d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndicatorViewPager.java */
    /* loaded from: classes3.dex */
    public class a implements a.c {
        a() {
        }

        @Override // com.shizhefei.view.indicator.a.c
        public void a(View view, int i2, int i3) {
            b bVar = b.this;
            ViewPager viewPager = bVar.b;
            if (!(viewPager instanceof SViewPager)) {
                viewPager.setCurrentItem(i2, bVar.f7154d);
            } else {
                viewPager.setCurrentItem(i2, ((SViewPager) viewPager).a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndicatorViewPager.java */
    /* renamed from: com.shizhefei.view.indicator.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0252b implements ViewPager.OnPageChangeListener {
        C0252b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            b.this.a.onPageScrollStateChanged(i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            b.this.a.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            b.this.a.setCurrentItem(i2, true);
            b bVar = b.this;
            f fVar = bVar.c;
            if (fVar != null) {
                fVar.a(bVar.a.a(), i2);
            }
        }
    }

    /* compiled from: IndicatorViewPager.java */
    /* loaded from: classes3.dex */
    public interface c {
        a.b getIndicatorAdapter();

        PagerAdapter getPagerAdapter();
    }

    /* compiled from: IndicatorViewPager.java */
    /* loaded from: classes3.dex */
    public static abstract class d extends e {
        private boolean loop;
        private com.shizhefei.view.viewpager.b pagerAdapter = new a();
        private a.b indicatorAdapter = new C0253b();

        /* compiled from: IndicatorViewPager.java */
        /* loaded from: classes3.dex */
        class a extends com.shizhefei.view.viewpager.b {
            a() {
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (d.this.getCount() == 0) {
                    return 0;
                }
                if (d.this.loop) {
                    return 2147483547;
                }
                return d.this.getCount();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getItemPosition(Object obj) {
                return d.this.getItemPosition(obj);
            }

            @Override // com.shizhefei.view.viewpager.b
            public int getItemViewType(int i2) {
                d dVar = d.this;
                return dVar.getPageViewType(dVar.getRealPosition(i2));
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public float getPageWidth(int i2) {
                d dVar = d.this;
                return dVar.getPageRatio(dVar.getRealPosition(i2));
            }

            @Override // com.shizhefei.view.viewpager.b
            public View getView(int i2, View view, ViewGroup viewGroup) {
                d dVar = d.this;
                return dVar.getViewForPage(dVar.getRealPosition(i2), view, viewGroup);
            }

            @Override // com.shizhefei.view.viewpager.b
            public int getViewTypeCount() {
                return d.this.getPageViewTypeCount();
            }
        }

        /* compiled from: IndicatorViewPager.java */
        /* renamed from: com.shizhefei.view.indicator.b$d$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0253b extends a.b {
            C0253b() {
            }

            @Override // com.shizhefei.view.indicator.a.b
            public int a() {
                return d.this.getCount();
            }

            @Override // com.shizhefei.view.indicator.a.b
            public View b(int i2, View view, ViewGroup viewGroup) {
                return d.this.getViewForTab(i2, view, viewGroup);
            }
        }

        @Override // com.shizhefei.view.indicator.b.e
        public abstract int getCount();

        @Override // com.shizhefei.view.indicator.b.c
        public a.b getIndicatorAdapter() {
            return this.indicatorAdapter;
        }

        public abstract int getItemPosition(Object obj);

        public float getPageRatio(int i2) {
            return 1.0f;
        }

        public int getPageViewType(int i2) {
            return 0;
        }

        public int getPageViewTypeCount() {
            return 1;
        }

        @Override // com.shizhefei.view.indicator.b.c
        public PagerAdapter getPagerAdapter() {
            return this.pagerAdapter;
        }

        @Override // com.shizhefei.view.indicator.b.e
        int getRealPosition(int i2) {
            if (getCount() == 0) {
                return 0;
            }
            return i2 % getCount();
        }

        public abstract View getViewForPage(int i2, View view, ViewGroup viewGroup);

        public abstract View getViewForTab(int i2, View view, ViewGroup viewGroup);

        public void notifyDataSetChanged() {
            this.indicatorAdapter.d();
            this.pagerAdapter.notifyDataSetChanged();
        }

        @Override // com.shizhefei.view.indicator.b.e
        void setLoop(boolean z) {
            this.loop = z;
            this.indicatorAdapter.f(z);
        }
    }

    /* compiled from: IndicatorViewPager.java */
    /* loaded from: classes3.dex */
    static abstract class e implements c {
        e() {
        }

        abstract int getCount();

        abstract int getRealPosition(int i2);

        abstract void setLoop(boolean z);
    }

    /* compiled from: IndicatorViewPager.java */
    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2, int i3);
    }

    public b(com.shizhefei.view.indicator.a aVar, ViewPager viewPager) {
        this(aVar, viewPager, true);
    }

    protected void b() {
        this.a.setOnItemSelectListener(new a());
    }

    protected void c() {
        this.b.addOnPageChangeListener(new C0252b());
    }

    public void d(c cVar) {
        this.b.setAdapter(cVar.getPagerAdapter());
        this.a.setAdapter(cVar.getIndicatorAdapter());
    }

    public void e(int i2, boolean z) {
        this.b.setCurrentItem(i2, z);
        this.a.setCurrentItem(i2, z);
    }

    public b(com.shizhefei.view.indicator.a aVar, ViewPager viewPager, boolean z) {
        this.f7154d = true;
        this.a = aVar;
        this.b = viewPager;
        aVar.setItemClickable(z);
        b();
        c();
    }
}
