package us.pinguo.common.recycler.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.s;
import us.pinguo.common.recycler.a.c;
import us.pinguo.common.recycler.a.d;
/* compiled from: BaseRecyclerAdapter.kt */
/* loaded from: classes4.dex */
public final class b<T, C extends c<T, VH>, VH extends d> extends RecyclerView.Adapter<VH> {
    private List<C> a = new ArrayList();
    private RecyclerView b;

    public b() {
        new AtomicBoolean(false);
        new ArrayList();
    }

    public final C e(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        List<C> list = this.a;
        s.e(list);
        return list.get(i2);
    }

    public void f(VH holder, int i2) {
        s.h(holder, "holder");
        s.e(null);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(VH holder, int i2, List<? extends Object> payloads) {
        s.h(holder, "holder");
        s.h(payloads, "payloads");
        C e2 = e(i2);
        if (e2 != null) {
            e2.p(this);
            RecyclerView recyclerView = this.b;
            s.e(recyclerView);
            e2.q(recyclerView);
            e2.a(holder, payloads);
        }
    }

    public final List<C> getCells() {
        return this.a;
    }

    public final int getFirstPositionByType(int i2) {
        int itemCount = getItemCount();
        int i3 = 0;
        while (i3 < itemCount) {
            int i4 = i3 + 1;
            C e2 = e(i3);
            s.e(e2);
            if (e2.h() == i2) {
                return i3;
            }
            i3 = i4;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<C> list = this.a;
        if (list == null) {
            return 0;
        }
        s.e(list);
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        C e2 = e(i2);
        if (e2 != null) {
            return e2.h();
        }
        throw new IllegalArgumentException(s.q("position:", Integer.valueOf(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public VH onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        this.b = (RecyclerView) parent;
        C e2 = e(getFirstPositionByType(i2));
        s.e(e2);
        return (VH) e2.c(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onViewRecycled(VH holder) {
        s.h(holder, "holder");
        super.onViewRecycled(holder);
        holder.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        f((d) viewHolder, i2);
        throw null;
    }

    public final void setCells(List<C> mCells) {
        s.h(mCells, "mCells");
        this.a = mCells;
    }
}
