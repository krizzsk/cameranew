package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.x;
/* compiled from: CommonEditItemAdapter.kt */
/* loaded from: classes4.dex */
public class a0<T extends us.pinguo.edit2020.bean.x> extends RecyclerView.Adapter<b0> {
    private kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> a;
    private kotlin.jvm.b.r<? super Integer, ? super Integer, ? super T, ? super b0, kotlin.u> b;
    private final ArrayList<T> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private int f10118d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10119e;

    /* renamed from: f  reason: collision with root package name */
    private Set<Integer> f10120f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f10121g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10122h;

    private final void g(b0 b0Var, int i2) {
        T t = this.c.get(i2);
        kotlin.jvm.internal.s.g(t, "dataList[position]");
        T t2 = t;
        b0Var.a().setImageResource(t2.d());
        b0Var.c().setText(t2.c());
        AppCompatImageView b = b0Var.b();
        int i3 = !t2.a() || kotlin.jvm.internal.s.c(this.f10121g, Boolean.TRUE) ? 4 : 0;
        b.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b, i3);
        AppCompatImageView e2 = b0Var.e();
        int i4 = !t2.e() || (t2 instanceof us.pinguo.edit2020.bean.k) || this.f10122h ? 4 : 0;
        e2.setVisibility(i4);
        VdsAgent.onSetViewVisibility(e2, i4);
        View f2 = b0Var.f();
        if (f2 != null) {
            int i5 = t2.b() ^ true ? 4 : 0;
            f2.setVisibility(i5);
            VdsAgent.onSetViewVisibility(f2, i5);
        }
        Context context = b0Var.a().getContext();
        if (this.f10118d != i2 && !this.f10119e) {
            us.pinguo.foundation.utils.q qVar = us.pinguo.foundation.utils.q.a;
            kotlin.jvm.internal.s.g(context, "context");
            int i6 = R.color.edit_function_unselect;
            qVar.a(context, i6, t2.d(), b0Var.a());
            b0Var.c().setTextColor(ContextCompat.getColor(context, i6));
            b0Var.e().setImageResource(R.drawable.dot_unselect);
            return;
        }
        us.pinguo.foundation.utils.q qVar2 = us.pinguo.foundation.utils.q.a;
        kotlin.jvm.internal.s.g(context, "context");
        int i7 = R.color.edit_function_select;
        qVar2.a(context, i7, t2.d(), b0Var.a());
        b0Var.c().setTextColor(ContextCompat.getColor(context, i7));
        b0Var.e().setImageResource(R.drawable.dot_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(a0 this$0, int i2, us.pinguo.edit2020.bean.x function, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(function, "$function");
        if (this$0.f10118d != i2 || this$0.f10119e) {
            Set<Integer> set = this$0.f10120f;
            if (set != null && set.contains(Integer.valueOf(i2))) {
                kotlin.jvm.b.p<Integer, T, kotlin.u> j2 = this$0.j();
                if (j2 == null) {
                    return;
                }
                j2.invoke(Integer.valueOf(i2), function);
                return;
            }
            int i3 = this$0.f10118d;
            this$0.f10118d = i2;
            if (i3 >= 0) {
                this$0.notifyItemChanged(i3);
            }
            this$0.notifyItemChanged(i2);
            kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar = this$0.a;
            if (pVar == null) {
                return;
            }
            pVar.invoke(Integer.valueOf(i2), function);
        }
    }

    public static /* synthetic */ void u(a0 a0Var, List list, Integer num, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshData");
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        a0Var.t(list, num, z);
    }

    public final void A(kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar) {
        this.a = pVar;
    }

    public final void B(int i2) {
        this.f10118d = i2;
    }

    public final void C(kotlin.jvm.b.r<? super Integer, ? super Integer, ? super T, ? super b0, kotlin.u> rVar) {
        this.b = rVar;
    }

    public final void D() {
        notifyDataSetChanged();
    }

    public final void E() {
        int i2 = this.f10118d;
        if (i2 == -1) {
            return;
        }
        notifyItemChanged(i2);
    }

    public final void e(boolean z, int... deselectPosition) {
        Set<Integer> set;
        kotlin.jvm.internal.s.h(deselectPosition, "deselectPosition");
        if (this.f10120f == null) {
            this.f10120f = new LinkedHashSet();
        }
        if (z && (set = this.f10120f) != null) {
            set.clear();
        }
        int i2 = 0;
        int length = deselectPosition.length;
        while (i2 < length) {
            int i3 = deselectPosition[i2];
            i2++;
            Set<Integer> set2 = this.f10120f;
            kotlin.jvm.internal.s.e(set2);
            set2.add(Integer.valueOf(i3));
        }
    }

    public final void f() {
        int i2 = this.f10118d;
        if (i2 < 0) {
            return;
        }
        this.f10118d = -1;
        notifyItemChanged(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final ArrayList<T> h() {
        return this.c;
    }

    public final T i(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.c.get(i2);
    }

    public final kotlin.jvm.b.p<Integer, T, kotlin.u> j() {
        return (kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u>) this.a;
    }

    public final T k() {
        int i2 = this.f10118d;
        if (i2 < 0) {
            return null;
        }
        return this.c.get(i2);
    }

    public final int l() {
        return this.f10118d;
    }

    public final Set<Integer> m() {
        return this.f10120f;
    }

    public final void o() {
        kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar;
        int i2 = this.f10118d;
        if (i2 == -1 || (pVar = this.a) == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(i2);
        T t = this.c.get(this.f10118d);
        kotlin.jvm.internal.s.g(t, "dataList[selectedIndex]");
        pVar.invoke(valueOf, t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(b0 holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        T t = this.c.get(i2);
        kotlin.jvm.internal.s.g(t, "dataList[position]");
        final T t2 = t;
        kotlin.jvm.b.r<? super Integer, ? super Integer, ? super T, ? super b0, kotlin.u> rVar = this.b;
        if (rVar == null) {
            g(holder, i2);
        } else {
            rVar.invoke(Integer.valueOf(i2), Integer.valueOf(this.f10118d), t2, holder);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.q(a0.this, i2, t2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public b0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_function_item_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new b0(inflate);
    }

    public void s(Integer num) {
        boolean z;
        Set<Integer> set = this.f10120f;
        boolean z2 = false;
        if (set != null) {
            z = kotlin.collections.c0.z(set, num);
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            this.f10118d = num == null ? -1 : num.intValue();
        }
        notifyDataSetChanged();
        if (num == null) {
            return;
        }
        num.intValue();
        kotlin.jvm.b.p<Integer, T, kotlin.u> j2 = j();
        if (j2 == null) {
            return;
        }
        T t = h().get(num.intValue());
        kotlin.jvm.internal.s.g(t, "dataList[selected]");
        j2.invoke(num, t);
    }

    public final void t(List<? extends T> list, Integer num, boolean z) {
        kotlin.jvm.internal.s.h(list, "list");
        this.c.clear();
        this.c.addAll(list);
        this.f10119e = z;
        s(num);
    }

    public final void v(int i2) {
        this.f10118d = i2;
        notifyItemRangeChanged(0, getItemCount());
        kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar = this.a;
        if (pVar == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(i2);
        T t = this.c.get(i2);
        kotlin.jvm.internal.s.g(t, "dataList[selected]");
        pVar.invoke(valueOf, t);
    }

    public void w() {
    }

    public final void x(boolean z) {
        this.f10122h = z;
    }

    public final void y(Boolean bool) {
        this.f10121g = bool;
    }

    public final void z(int i2) {
        int i3 = this.f10118d;
        if (i3 == i2) {
            return;
        }
        this.f10118d = i2;
        if (i3 != -1) {
            notifyItemChanged(i3);
        }
        notifyItemChanged(i2);
    }
}
