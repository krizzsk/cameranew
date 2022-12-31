package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.pinguo.camera360.homepage.m0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import kotlin.z.d;
import kotlin.z.j;
import us.pinguo.util.g;
/* compiled from: HomePageSimpleBannerIndicator.kt */
/* loaded from: classes3.dex */
public final class HomePageSimpleBannerIndicator extends View {
    private final int a;
    private final int b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f6812d;

    /* renamed from: e  reason: collision with root package name */
    private final float f6813e;

    /* renamed from: f  reason: collision with root package name */
    private final float f6814f;

    /* renamed from: g  reason: collision with root package name */
    private float f6815g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f6816h;

    /* renamed from: i  reason: collision with root package name */
    private int f6817i;

    /* renamed from: j  reason: collision with root package name */
    private int f6818j;

    /* compiled from: HomePageSimpleBannerIndicator.kt */
    /* loaded from: classes3.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            HomePageSimpleBannerIndicator.this.setIndex(i2);
        }
    }

    /* compiled from: HomePageSimpleBannerIndicator.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ m0 b;
        final /* synthetic */ ViewPager2 c;

        b(m0 m0Var, ViewPager2 viewPager2) {
            this.b = m0Var;
            this.c = viewPager2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            int currentItem;
            HomePageSimpleBannerIndicator homePageSimpleBannerIndicator = HomePageSimpleBannerIndicator.this;
            if (this.b.h() > 1) {
                if (i2 == 0) {
                    currentItem = HomePageSimpleBannerIndicator.this.a();
                } else if (i2 == this.b.getItemCount() - 1) {
                    i2 = 0;
                } else {
                    currentItem = this.c.getCurrentItem();
                }
                i2 = currentItem - 1;
            }
            homePageSimpleBannerIndicator.setIndex(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageSimpleBannerIndicator(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = Color.parseColor("#999999");
        this.b = Color.parseColor("#2d2d2d");
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = g.b(context2, 4.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6812d = g.b(context3, 4.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f6813e = g.b(context4, 12.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f6814f = g.b(context5, 6.0f);
        Paint paint = new Paint(1);
        this.f6816h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f6817i = 3;
    }

    public final int a() {
        return this.f6817i;
    }

    public final int b() {
        return this.f6818j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        d h2;
        float f2;
        s.h(canvas, "canvas");
        int i3 = this.f6817i;
        if (i3 > 0 && (i2 = this.f6818j) >= 0 && i2 < i3) {
            float measuredHeight = (getMeasuredHeight() * 0.5f) - (this.c * 0.5f);
            float f3 = this.f6815g;
            h2 = j.h(0, this.f6817i);
            Iterator<Integer> it = h2.iterator();
            while (it.hasNext()) {
                if (((h0) it).nextInt() == b()) {
                    this.f6816h.setColor(this.b);
                    f2 = this.f6813e;
                } else {
                    this.f6816h.setColor(this.a);
                    f2 = this.f6812d;
                }
                float f4 = f2;
                canvas.drawRect(f3, measuredHeight, f3 + f4, measuredHeight + this.c, this.f6816h);
                f3 += f4 + this.f6814f;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.f6817i;
        this.f6815g = (measuredWidth - ((((i4 - 1) * this.f6814f) + this.f6813e) + ((i4 - 1) * this.f6812d))) * 0.5f;
    }

    public final void setCount(int i2) {
        if (i2 != this.f6817i) {
            this.f6817i = i2;
            invalidate();
        }
    }

    public final void setIndex(int i2) {
        if (i2 != this.f6818j) {
            this.f6818j = i2;
            invalidate();
        }
    }

    public final void setUpWithViewPager(ViewPager pager) {
        s.h(pager, "pager");
        pager.addOnPageChangeListener(new a());
        PagerAdapter adapter = pager.getAdapter();
        setCount(adapter == null ? 0 : adapter.getCount());
        setIndex(pager.getCurrentItem());
    }

    public final void setUpWithViewPager2(ViewPager2 pager) {
        s.h(pager, "pager");
        RecyclerView.Adapter adapter = pager.getAdapter();
        m0 m0Var = adapter instanceof m0 ? (m0) adapter : null;
        if (m0Var == null) {
            return;
        }
        pager.registerOnPageChangeCallback(new b(m0Var, pager));
        setCount(m0Var.h());
        setIndex(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageSimpleBannerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = Color.parseColor("#999999");
        this.b = Color.parseColor("#2d2d2d");
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = g.b(context2, 4.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6812d = g.b(context3, 4.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f6813e = g.b(context4, 12.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f6814f = g.b(context5, 6.0f);
        Paint paint = new Paint(1);
        this.f6816h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f6817i = 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageSimpleBannerIndicator(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = Color.parseColor("#999999");
        this.b = Color.parseColor("#2d2d2d");
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = g.b(context2, 4.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6812d = g.b(context3, 4.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f6813e = g.b(context4, 12.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f6814f = g.b(context5, 6.0f);
        Paint paint = new Paint(1);
        this.f6816h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f6817i = 3;
    }
}
