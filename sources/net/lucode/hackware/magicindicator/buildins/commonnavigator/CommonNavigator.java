package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R;
import net.lucode.hackware.magicindicator.b;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;
/* loaded from: classes3.dex */
public class CommonNavigator extends FrameLayout implements net.lucode.hackware.magicindicator.c.a, b.a {
    private HorizontalScrollView a;
    private LinearLayout b;
    private LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    private c f8885d;

    /* renamed from: e  reason: collision with root package name */
    private net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a f8886e;

    /* renamed from: f  reason: collision with root package name */
    private b f8887f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8888g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8889h;

    /* renamed from: i  reason: collision with root package name */
    private float f8890i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8891j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8892k;

    /* renamed from: l  reason: collision with root package name */
    private int f8893l;
    private int m;
    private boolean n;
    private boolean o;
    private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> p;
    private DataSetObserver q;

    /* loaded from: classes3.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f8887f.m(CommonNavigator.this.f8886e.a());
            CommonNavigator.this.k();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f8890i = 0.5f;
        this.f8891j = true;
        this.f8892k = true;
        this.o = true;
        this.p = new ArrayList();
        this.q = new a();
        b bVar = new b();
        this.f8887f = bVar;
        bVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View inflate;
        removeAllViews();
        if (this.f8888g) {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this);
        } else {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        }
        this.a = (HorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.b = linearLayout;
        linearLayout.setPadding(this.m, 0, this.f8893l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        this.c = linearLayout2;
        if (this.n) {
            linearLayout2.getParent().bringChildToFront(this.c);
        }
        l();
    }

    private void l() {
        LinearLayout.LayoutParams layoutParams;
        int g2 = this.f8887f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            d c = this.f8886e.c(getContext(), i2);
            if (c instanceof View) {
                View view = (View) c;
                if (this.f8888g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f8886e.d(getContext(), i2);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.b.addView(view, layoutParams);
            }
        }
        net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar = this.f8886e;
        if (aVar != null) {
            c b = aVar.b(getContext());
            this.f8885d = b;
            if (b instanceof View) {
                this.c.addView((View) this.f8885d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void m() {
        this.p.clear();
        int g2 = this.f8887f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar = new net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a();
            View childAt = this.b.getChildAt(i2);
            if (childAt != null) {
                aVar.a = childAt.getLeft();
                aVar.b = childAt.getTop();
                aVar.c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f8894d = bottom;
                if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b) {
                    net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b bVar = (net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b) childAt;
                    aVar.f8895e = bVar.h();
                    aVar.f8896f = bVar.e();
                    aVar.f8897g = bVar.g();
                    aVar.f8898h = bVar.f();
                } else {
                    aVar.f8895e = aVar.a;
                    aVar.f8896f = aVar.b;
                    aVar.f8897g = aVar.c;
                    aVar.f8898h = bottom;
                }
            }
            this.p.add(aVar);
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void a(int i2, int i3) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).a(i2, i3);
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void b(int i2, int i3, float f2, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).b(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void c(int i2, int i3) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).c(i2, i3);
        }
        if (this.f8888g || this.f8892k || this.a == null || this.p.size() <= 0) {
            return;
        }
        net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar = this.p.get(Math.min(this.p.size() - 1, i2));
        if (this.f8889h) {
            float a2 = aVar.a() - (this.a.getWidth() * this.f8890i);
            if (this.f8891j) {
                this.a.smoothScrollTo((int) a2, 0);
                return;
            } else {
                this.a.scrollTo((int) a2, 0);
                return;
            }
        }
        int scrollX = this.a.getScrollX();
        int i4 = aVar.a;
        if (scrollX > i4) {
            if (this.f8891j) {
                this.a.smoothScrollTo(i4, 0);
                return;
            } else {
                this.a.scrollTo(i4, 0);
                return;
            }
        }
        int scrollX2 = this.a.getScrollX() + getWidth();
        int i5 = aVar.c;
        if (scrollX2 < i5) {
            if (this.f8891j) {
                this.a.smoothScrollTo(i5 - getWidth(), 0);
            } else {
                this.a.scrollTo(i5 - getWidth(), 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void d(int i2, int i3, float f2, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).d(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void e() {
        k();
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void f() {
    }

    public d j(int i2) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return null;
        }
        return (d) linearLayout.getChildAt(i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f8886e != null) {
            m();
            c cVar = this.f8885d;
            if (cVar != null) {
                cVar.a(this.p);
            }
            if (this.o && this.f8887f.f() == 0) {
                onPageSelected(this.f8887f.e());
                onPageScrolled(this.f8887f.e(), 0.0f, 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageScrollStateChanged(int i2) {
        if (this.f8886e != null) {
            this.f8887f.h(i2);
            c cVar = this.f8885d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i2);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.f8886e != null) {
            this.f8887f.i(i2, f2, i3);
            c cVar = this.f8885d;
            if (cVar != null) {
                cVar.onPageScrolled(i2, f2, i3);
            }
            if (this.a == null || this.p.size() <= 0 || i2 < 0 || i2 >= this.p.size() || !this.f8892k) {
                return;
            }
            int min = Math.min(this.p.size() - 1, i2);
            int min2 = Math.min(this.p.size() - 1, i2 + 1);
            float a2 = this.p.get(min).a() - (this.a.getWidth() * this.f8890i);
            this.a.scrollTo((int) (a2 + (((this.p.get(min2).a() - (this.a.getWidth() * this.f8890i)) - a2) * f2)), 0);
        }
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageSelected(int i2) {
        if (this.f8886e != null) {
            this.f8887f.j(i2);
            c cVar = this.f8885d;
            if (cVar != null) {
                cVar.onPageSelected(i2);
            }
        }
    }

    public void setAdapter(net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar) {
        net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar2 = this.f8886e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.g(this.q);
        }
        this.f8886e = aVar;
        if (aVar != null) {
            aVar.f(this.q);
            this.f8887f.m(this.f8886e.a());
            if (this.b != null) {
                this.f8886e.e();
                return;
            }
            return;
        }
        this.f8887f.m(0);
        k();
    }

    public void setAdjustMode(boolean z) {
        this.f8888g = z;
    }

    public void setEnablePivotScroll(boolean z) {
        this.f8889h = z;
    }

    public void setFollowTouch(boolean z) {
        this.f8892k = z;
    }

    public void setIndicatorOnTop(boolean z) {
        this.n = z;
    }

    public void setLeftPadding(int i2) {
        this.m = i2;
    }

    public void setReselectWhenLayout(boolean z) {
        this.o = z;
    }

    public void setRightPadding(int i2) {
        this.f8893l = i2;
    }

    public void setScrollPivotX(float f2) {
        this.f8890i = f2;
    }

    public void setSkimOver(boolean z) {
        this.f8887f.l(z);
    }

    public void setSmoothScroll(boolean z) {
        this.f8891j = z;
    }
}
