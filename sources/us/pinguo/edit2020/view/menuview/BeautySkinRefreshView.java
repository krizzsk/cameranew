package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.a0;
import us.pinguo.edit2020.adapter.p0;
import us.pinguo.edit2020.bean.n0;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: BeautySkinRefreshView.kt */
/* loaded from: classes4.dex */
public final class BeautySkinRefreshView extends ConstraintLayout {
    public Map<Integer, View> a;
    private a0<n0> b;
    private a0<n0> c;

    /* renamed from: d  reason: collision with root package name */
    private l<? super n0, u> f10793d;

    /* renamed from: e  reason: collision with root package name */
    private l<? super n0, u> f10794e;

    /* renamed from: f  reason: collision with root package name */
    private a0<n0> f10795f;

    /* renamed from: g  reason: collision with root package name */
    private int f10796g;

    /* renamed from: h  reason: collision with root package name */
    public CenterLayoutManager f10797h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.f10796g = -1;
        n(context);
    }

    private final void n(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_common_simple_recyclerlist, this);
        ((RecyclerView) _$_findCachedViewById(R.id.recyclerView)).setClipChildren(false);
    }

    public static /* synthetic */ void r(BeautySkinRefreshView beautySkinRefreshView, ArrayList arrayList, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        beautySkinRefreshView.q(arrayList, i2);
    }

    public static /* synthetic */ void t(BeautySkinRefreshView beautySkinRefreshView, ArrayList arrayList, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        beautySkinRefreshView.s(arrayList, i2);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final a0<n0> g() {
        return this.b;
    }

    public final CenterLayoutManager h() {
        CenterLayoutManager centerLayoutManager = this.f10797h;
        if (centerLayoutManager != null) {
            return centerLayoutManager;
        }
        s.z("layoutManager");
        throw null;
    }

    public final n0 i() {
        a0<n0> a0Var = this.c;
        if (a0Var != null && a0Var.l() >= 0) {
            return a0Var.h().get(a0Var.l());
        }
        return null;
    }

    public final l<n0, u> j() {
        return this.f10793d;
    }

    public final l<n0, u> k() {
        return this.f10794e;
    }

    public final n0 l() {
        a0<n0> a0Var = this.f10795f;
        if (a0Var == null) {
            return null;
        }
        return a0Var.k();
    }

    public final int m() {
        return this.f10796g;
    }

    public final void o() {
        CenterLayoutManager h2 = h();
        Context context = getContext();
        s.g(context, "context");
        a0<n0> a0Var = this.c;
        h2.b(context, a0Var == null ? 0 : a0Var.l(), 5.0f);
    }

    public final void p() {
        a0<n0> a0Var = this.b;
        if (a0Var != null) {
            a0Var.B(0);
        }
        a0<n0> a0Var2 = this.c;
        if (a0Var2 != null) {
            a0Var2.B(0);
        }
        a0<n0> a0Var3 = this.c;
        if (a0Var3 == null) {
            return;
        }
        a0Var3.w();
    }

    public final void q(ArrayList<n0> dataList, int i2) {
        int l2;
        int l3;
        s.h(dataList, "dataList");
        a0<n0> a0Var = this.b;
        if (a0Var == null) {
            Context context = getContext();
            s.g(context, "context");
            setLayoutManager(new CenterLayoutManager(context, 0, false));
            int i3 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(h());
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) _$_findCachedViewById(i3)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            a0<n0> a0Var2 = new a0<>();
            a0Var2.e(true, 1);
            if (i2 >= 0) {
                l3 = i2;
            } else {
                l3 = a0Var2.l() >= 0 ? a0Var2.l() : 0;
            }
            a0.u(a0Var2, dataList, Integer.valueOf(l3), false, 4, null);
            a0Var2.A(new BeautySkinRefreshView$showAutoData$1(this));
            this.b = a0Var2;
            ((RecyclerView) _$_findCachedViewById(i3)).setAdapter(a0Var2);
            g gVar = new g();
            Context context2 = getContext();
            s.g(context2, "context");
            int itemCount = a0Var2.getItemCount();
            CenterLayoutManager h2 = h();
            Context context3 = getContext();
            s.g(context3, "context");
            gVar.a(context2, itemCount, h2.a(context3, a0Var2.getItemCount()));
            if (((RecyclerView) _$_findCachedViewById(i3)).getItemDecorationCount() == 1) {
                ((RecyclerView) _$_findCachedViewById(i3)).removeItemDecorationAt(0);
            }
            ((RecyclerView) _$_findCachedViewById(i3)).addItemDecoration(gVar);
            a0Var = a0Var2;
        } else {
            int i4 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i4)).setAdapter(a0Var);
            if (i2 >= 0) {
                l2 = i2;
            } else {
                l2 = a0Var.l() >= 0 ? a0Var.l() : 0;
            }
            Context context4 = getContext();
            s.g(context4, "context");
            int itemCount2 = a0Var.getItemCount();
            CenterLayoutManager h3 = h();
            Context context5 = ((RecyclerView) _$_findCachedViewById(i4)).getContext();
            s.g(context5, "recyclerView.context");
            ((g) ((RecyclerView) _$_findCachedViewById(i4)).getItemDecorationAt(0)).a(context4, itemCount2, h3.a(context5, a0Var.getItemCount()));
            a0.u(a0Var, dataList, Integer.valueOf(l2), false, 4, null);
            CenterLayoutManager h4 = h();
            Context context6 = getContext();
            s.g(context6, "context");
            h4.b(context6, l2, 25.0f);
            this.b = a0Var;
        }
        this.f10795f = a0Var;
    }

    public final void s(ArrayList<n0> dataList, int i2) {
        int l2;
        int l3;
        s.h(dataList, "dataList");
        a0<n0> a0Var = this.c;
        if (a0Var == null) {
            p0 p0Var = new p0();
            this.c = p0Var;
            p0Var.A(new BeautySkinRefreshView$showManualData$1(this));
            if (i2 >= 0) {
                l3 = i2;
            } else {
                l3 = p0Var.l() >= 0 ? p0Var.l() : 0;
            }
            a0.u(p0Var, dataList, Integer.valueOf(l3), false, 4, null);
            int i3 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i3)).setAdapter(p0Var);
            g gVar = new g();
            Context context = getContext();
            s.g(context, "context");
            int itemCount = p0Var.getItemCount();
            CenterLayoutManager h2 = h();
            Context context2 = getContext();
            s.g(context2, "context");
            gVar.a(context, itemCount, h2.a(context2, p0Var.getItemCount()));
            if (((RecyclerView) _$_findCachedViewById(i3)).getItemDecorationCount() == 1) {
                ((RecyclerView) _$_findCachedViewById(i3)).removeItemDecorationAt(0);
            }
            ((RecyclerView) _$_findCachedViewById(i3)).addItemDecoration(gVar);
        } else {
            int i4 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i4)).setAdapter(a0Var);
            if (i2 >= 0) {
                l2 = i2;
            } else {
                l2 = a0Var.l() >= 0 ? a0Var.l() : 0;
            }
            Context context3 = getContext();
            s.g(context3, "context");
            int itemCount2 = a0Var.getItemCount();
            CenterLayoutManager h3 = h();
            Context context4 = ((RecyclerView) _$_findCachedViewById(i4)).getContext();
            s.g(context4, "recyclerView.context");
            ((g) ((RecyclerView) _$_findCachedViewById(i4)).getItemDecorationAt(0)).a(context3, itemCount2, h3.a(context4, a0Var.getItemCount()));
            a0.u(a0Var, dataList, Integer.valueOf(l2), false, 4, null);
            CenterLayoutManager h4 = h();
            Context context5 = getContext();
            s.g(context5, "context");
            h4.b(context5, a0Var.l(), 25.0f);
        }
        this.f10795f = this.c;
    }

    public final void setAutoAdapter(a0<n0> a0Var) {
        this.b = a0Var;
    }

    public final void setCurrentAdapter(a0<n0> a0Var) {
        this.f10795f = a0Var;
    }

    public final void setDefaultSelected() {
        a0<n0> a0Var = this.f10795f;
        if (a0Var == null) {
            return;
        }
        a0Var.v(0);
    }

    public final void setLayoutManager(CenterLayoutManager centerLayoutManager) {
        s.h(centerLayoutManager, "<set-?>");
        this.f10797h = centerLayoutManager;
    }

    public final void setManualAdapter(a0<n0> a0Var) {
        this.c = a0Var;
    }

    public final void setOnItemChanged(l<? super n0, u> lVar) {
        this.f10793d = lVar;
    }

    public final void setOnManualItemChanged(l<? super n0, u> lVar) {
        this.f10794e = lVar;
    }

    public final void setSelectedPosition(int i2) {
        this.f10796g = i2;
    }

    public final void u() {
        a0<n0> a0Var = this.f10795f;
        if (a0Var == null) {
            return;
        }
        a0Var.notifyDataSetChanged();
    }

    public final void v() {
        a0<n0> a0Var = this.f10795f;
        if (a0Var == null) {
            return;
        }
        a0Var.E();
    }

    public final void w(int i2) {
        n0 i3;
        a0<n0> a0Var = this.b;
        if (a0Var == null || (i3 = a0Var.i(1)) == null) {
            return;
        }
        i3.g().setCurrentValue(i2);
        a0Var.notifyItemChanged(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f10796g = -1;
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f10796g = -1;
        n(context);
    }
}
