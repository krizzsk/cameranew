package us.pinguo.edit2020.utils;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
/* compiled from: TabLayoutHelper.kt */
/* loaded from: classes4.dex */
public final class j {
    private final i a;

    /* compiled from: TabLayoutHelper.kt */
    /* loaded from: classes4.dex */
    public static final class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f fVar) {
            if ((fVar == null ? null : fVar.e()) == null) {
                return;
            }
            View e2 = fVar.e();
            s.e(e2);
            TextView textView = (TextView) e2.findViewById(R.id.tv_tab);
            Integer k2 = j.this.a.k();
            if (k2 == null || k2.intValue() != 0) {
                Integer k3 = j.this.a.k();
                s.e(k3);
                textView.setTextColor(k3.intValue());
            }
            if (j.this.a.j()) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
            Integer i2 = j.this.a.i();
            if (i2 == null || i2.intValue() != 0) {
                Integer i3 = j.this.a.i();
                s.e(i3);
                textView.setBackgroundColor(i3.intValue());
            }
            View e3 = fVar.e();
            s.e(e3);
            View findViewById = e3.findViewById(R.id.view_indicator);
            s.g(findViewById, "tab.customView!!.findVie…iew>(R.id.view_indicator)");
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f fVar) {
            if ((fVar == null ? null : fVar.e()) == null) {
                return;
            }
            View e2 = fVar.e();
            s.e(e2);
            TextView textView = (TextView) e2.findViewById(R.id.tv_tab);
            Integer h2 = j.this.a.h();
            if (h2 == null || h2.intValue() != 0) {
                Integer h3 = j.this.a.h();
                s.e(h3);
                textView.setTextColor(h3.intValue());
            }
            textView.setTypeface(Typeface.defaultFromStyle(0));
            Integer g2 = j.this.a.g();
            if (g2 == null || g2.intValue() != 0) {
                Integer g3 = j.this.a.g();
                s.e(g3);
                textView.setBackgroundColor(g3.intValue());
            }
            View e3 = fVar.e();
            s.e(e3);
            View findViewById = e3.findViewById(R.id.view_indicator);
            s.g(findViewById, "tab.customView!!.findVie…iew>(R.id.view_indicator)");
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
        }
    }

    public j(i builder) {
        s.h(builder, "builder");
        this.a = builder;
        TabLayout p = builder.p();
        if (p != null) {
            c(p);
            b(p);
        }
    }

    private final void b(TabLayout tabLayout) {
        tabLayout.d(new a());
    }

    private final void c(final TabLayout tabLayout) {
        tabLayout.post(new Runnable() { // from class: us.pinguo.edit2020.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                j.d(TabLayout.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TabLayout tabLayout, j this$0) {
        s.h(tabLayout, "$tabLayout");
        s.h(this$0, "this$0");
        View childAt = tabLayout.getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) childAt;
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            int i3 = i2 + 1;
            TabLayout.f z = tabLayout.z(i2);
            if (z == null) {
                return;
            }
            CharSequence i4 = z.i();
            z.n(R.layout.item_tab_view);
            View e2 = z.e();
            if (e2 == null) {
                return;
            }
            TextView textView = (TextView) e2.findViewById(R.id.tv_tab);
            textView.setText(i4);
            Integer g2 = this$0.a.g();
            if (g2 == null || g2.intValue() != 0) {
                Integer g3 = this$0.a.g();
                s.e(g3);
                textView.setBackgroundColor(g3.intValue());
            }
            View indicator = e2.findViewById(R.id.view_indicator);
            if (i2 == 0) {
                Integer k2 = this$0.a.k();
                textView.setTextColor(k2 == null ? ViewCompat.MEASURED_STATE_MASK : k2.intValue());
                if (this$0.a.j()) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
                Integer i5 = this$0.a.i();
                if (i5 == null || i5.intValue() != 0) {
                    Integer i6 = this$0.a.i();
                    s.e(i6);
                    textView.setBackgroundColor(i6.intValue());
                }
                s.g(indicator, "indicator");
                indicator.setVisibility(0);
                VdsAgent.onSetViewVisibility(indicator, 0);
            }
            ViewGroup.LayoutParams layoutParams = indicator.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            Integer f2 = this$0.a.f();
            if (f2 == null || f2.intValue() != 0) {
                Integer f3 = this$0.a.f();
                s.e(f3);
                layoutParams2.width = f3.intValue();
            }
            Integer d2 = this$0.a.d();
            if (d2 == null || d2.intValue() != 0) {
                Integer d3 = this$0.a.d();
                s.e(d3);
                layoutParams2.height = d3.intValue();
            }
            Integer b = this$0.a.b();
            if (b == null || b.intValue() != 0) {
                Integer b2 = this$0.a.b();
                s.e(b2);
                indicator.setBackgroundColor(b2.intValue());
            }
            Integer e3 = this$0.a.e();
            if (e3 == null || e3.intValue() != 0) {
                Integer e4 = this$0.a.e();
                layoutParams2.rightMargin = e4 == null ? 0 : e4.intValue();
                Integer e5 = this$0.a.e();
                layoutParams2.leftMargin = e5 == null ? 0 : e5.intValue();
            }
            Integer a2 = this$0.a.a();
            if (a2 == null || a2.intValue() != 0) {
                Integer a3 = this$0.a.a();
                layoutParams2.bottomMargin = a3 == null ? 0 : a3.intValue();
            }
            Integer c = this$0.a.c();
            if (c == null || c.intValue() != 0) {
                Integer c2 = this$0.a.c();
                s.e(c2);
                indicator.setBackgroundResource(c2.intValue());
            }
            View childAt2 = linearLayout.getChildAt(i2);
            Integer n = this$0.a.n();
            s.e(n);
            int intValue = n.intValue();
            Integer n2 = this$0.a.n();
            s.e(n2);
            childAt2.setPadding(intValue, 0, n2.intValue(), 0);
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getChildAt(i2).getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            Integer m = this$0.a.m();
            s.e(m);
            layoutParams4.rightMargin = m.intValue();
            Integer l2 = this$0.a.l();
            s.e(l2);
            layoutParams4.leftMargin = l2.intValue();
            Integer o = this$0.a.o();
            if (o == null || o.intValue() != 0) {
                Integer o2 = this$0.a.o();
                s.e(o2);
                layoutParams4.width = o2.intValue();
            }
            i2 = i3;
        }
    }
}
