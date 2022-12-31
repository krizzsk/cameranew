package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.a0;
import us.pinguo.edit2020.adapter.l0;
import us.pinguo.edit2020.bean.i;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: BeautySkinRefreshViewNew.kt */
/* loaded from: classes4.dex */
public final class BeautySkinRefreshViewNew extends ConstraintLayout {
    public Map<Integer, View> a;
    private CenterLayoutManager b;
    private l0 c;

    /* renamed from: d  reason: collision with root package name */
    private g f10798d;

    /* renamed from: e  reason: collision with root package name */
    private l<? super i, u> f10799e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshViewNew(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.f10798d = new g();
        h(context);
    }

    private final void h(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_common_simple_recyclerlist, this);
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

    public final l<i, u> g() {
        return this.f10799e;
    }

    public final void i() {
        l0 l0Var = this.c;
        if (l0Var == null) {
            return;
        }
        l0Var.B(-1);
    }

    public final void j(List<i> dataList, int i2, boolean z) {
        s.h(dataList, "dataList");
        l0 l0Var = this.c;
        int i3 = 0;
        if (l0Var == null) {
            Context context = getContext();
            s.g(context, "context");
            this.b = new CenterLayoutManager(context, 0, false);
            int i4 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i4)).setLayoutManager(this.b);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) _$_findCachedViewById(i4)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            l0 l0Var2 = new l0();
            l0Var2.M(z);
            if (i2 < 0) {
                i2 = 0;
            }
            l0Var2.A(new BeautySkinRefreshViewNew$show$1(this));
            a0.u(l0Var2, dataList, Integer.valueOf(i2), false, 4, null);
            this.c = l0Var2;
            ((RecyclerView) _$_findCachedViewById(i4)).setAdapter(l0Var2);
            g gVar = this.f10798d;
            Context context2 = getContext();
            s.g(context2, "context");
            int itemCount = l0Var2.getItemCount();
            CenterLayoutManager centerLayoutManager = this.b;
            if (centerLayoutManager != null) {
                Context context3 = getContext();
                s.g(context3, "context");
                i3 = centerLayoutManager.a(context3, l0Var2.getItemCount());
            }
            gVar.a(context2, itemCount, i3);
            ((RecyclerView) _$_findCachedViewById(i4)).addItemDecoration(this.f10798d);
            return;
        }
        if (i2 < 0) {
            i2 = l0Var.l() >= 0 ? l0Var.l() : 0;
        }
        g gVar2 = this.f10798d;
        Context context4 = getContext();
        s.g(context4, "context");
        int size = dataList.size();
        CenterLayoutManager centerLayoutManager2 = this.b;
        if (centerLayoutManager2 != null) {
            Context context5 = getContext();
            s.g(context5, "context");
            i3 = centerLayoutManager2.a(context5, dataList.size());
        }
        gVar2.a(context4, size, i3);
        l0Var.M(z);
        a0.u(l0Var, dataList, Integer.valueOf(i2), false, 4, null);
    }

    public final void k() {
        l0 l0Var = this.c;
        if (l0Var == null) {
            return;
        }
        l0Var.notifyDataSetChanged();
    }

    public final void l() {
        l0 l0Var = this.c;
        if (l0Var == null) {
            return;
        }
        l0Var.E();
    }

    public final void setOnItemChanged(l<? super i, u> lVar) {
        this.f10799e = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshViewNew(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f10798d = new g();
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshViewNew(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f10798d = new g();
        h(context);
    }
}
