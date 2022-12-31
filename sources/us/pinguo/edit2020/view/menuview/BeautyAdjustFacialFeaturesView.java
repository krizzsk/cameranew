package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.a0;
import us.pinguo.edit2020.bean.r;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: BeautyAdjustFacialFeaturesView.kt */
/* loaded from: classes4.dex */
public final class BeautyAdjustFacialFeaturesView extends ConstraintLayout {
    public Map<Integer, View> a;
    private a0<r> b;
    private p<? super Integer, ? super r, u> c;

    /* renamed from: d  reason: collision with root package name */
    public CenterLayoutManager f10789d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyAdjustFacialFeaturesView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        i(context);
    }

    private final void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.edit_facialfeatures_view_layout, this);
    }

    public static /* synthetic */ void k(BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView, ArrayList arrayList, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        beautyAdjustFacialFeaturesView.j(arrayList, i2);
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

    public final CenterLayoutManager g() {
        CenterLayoutManager centerLayoutManager = this.f10789d;
        if (centerLayoutManager != null) {
            return centerLayoutManager;
        }
        s.z("layoutManager");
        throw null;
    }

    public final p<Integer, r, u> h() {
        return this.c;
    }

    public final void j(ArrayList<r> dataList, int i2) {
        s.h(dataList, "dataList");
        a0<r> a0Var = this.b;
        if (a0Var == null) {
            Context context = getContext();
            s.g(context, "context");
            setLayoutManager(new CenterLayoutManager(context, 0, false));
            int i3 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(g());
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) _$_findCachedViewById(i3)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            a0<r> a0Var2 = new a0<>();
            a0Var2.e(true, 0);
            a0.u(a0Var2, dataList, Integer.valueOf(i2), false, 4, null);
            a0Var2.A(new BeautyAdjustFacialFeaturesView$refreshData$1$1(this));
            ((RecyclerView) _$_findCachedViewById(i3)).setAdapter(a0Var2);
            g gVar = new g();
            Context context2 = getContext();
            s.g(context2, "context");
            int itemCount = a0Var2.getItemCount();
            CenterLayoutManager g2 = g();
            Context context3 = ((RecyclerView) _$_findCachedViewById(i3)).getContext();
            s.g(context3, "recyclerView.context");
            gVar.a(context2, itemCount, g2.a(context3, a0Var2.getItemCount()));
            ((RecyclerView) _$_findCachedViewById(i3)).addItemDecoration(gVar);
            this.b = a0Var2;
            return;
        }
        a0.u(a0Var, dataList, Integer.valueOf(i2), false, 4, null);
        int i4 = R.id.recyclerView;
        Context context4 = getContext();
        s.g(context4, "context");
        int itemCount2 = a0Var.getItemCount();
        CenterLayoutManager g3 = g();
        Context context5 = ((RecyclerView) _$_findCachedViewById(i4)).getContext();
        s.g(context5, "recyclerView.context");
        ((g) ((RecyclerView) _$_findCachedViewById(i4)).getItemDecorationAt(0)).a(context4, itemCount2, g3.a(context5, a0Var.getItemCount()));
        CenterLayoutManager g4 = g();
        Context context6 = getContext();
        s.g(context6, "context");
        g4.b(context6, i2, 25.0f);
    }

    public final void l() {
        a0<r> a0Var = this.b;
        if (a0Var == null) {
            return;
        }
        a0Var.notifyDataSetChanged();
    }

    public final void m() {
        a0<r> a0Var = this.b;
        if (a0Var == null) {
            return;
        }
        a0Var.E();
    }

    public final void setFaceSelectTipVisible(boolean z) {
        TextView selectFaceTip = (TextView) _$_findCachedViewById(R.id.selectFaceTip);
        s.g(selectFaceTip, "selectFaceTip");
        int i2 = z ? 0 : 8;
        selectFaceTip.setVisibility(i2);
        VdsAgent.onSetViewVisibility(selectFaceTip, i2);
    }

    public final void setLayoutManager(CenterLayoutManager centerLayoutManager) {
        s.h(centerLayoutManager, "<set-?>");
        this.f10789d = centerLayoutManager;
    }

    public final void setMAdapter(a0<r> a0Var) {
        this.b = a0Var;
    }

    public final void setOnItemChanged(p<? super Integer, ? super r, u> pVar) {
        this.c = pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyAdjustFacialFeaturesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyAdjustFacialFeaturesView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        i(context);
    }
}
