package us.pinguo.common.recycler.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.common.recycler.a.d;
/* compiled from: BaseRecyclerCell.kt */
/* loaded from: classes4.dex */
public abstract class c<T, VH extends d> implements d.a {
    private boolean a;
    private T b;
    private VH c;

    /* renamed from: d  reason: collision with root package name */
    private b<T, ?, VH> f9945d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f9946e;

    /* compiled from: BaseRecyclerCell.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        final /* synthetic */ c<T, VH> a;

        a(c<T, VH> cVar) {
            this.a = cVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            VH g2;
            s.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (this.a.i() || (g2 = this.a.g()) == null) {
                return;
            }
            c<T, VH> cVar = this.a;
            RecyclerView f2 = cVar.f();
            Integer valueOf = f2 == null ? null : Integer.valueOf(f2.getChildAdapterPosition(g2.itemView));
            RecyclerView f3 = cVar.f();
            RecyclerView.LayoutManager layoutManager = f3 == null ? null : f3.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView f4 = cVar.f();
            RecyclerView.LayoutManager layoutManager2 = f4 != null ? f4.getLayoutManager() : null;
            Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (valueOf != null && new kotlin.z.d(findFirstVisibleItemPosition, ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition()).f(valueOf.intValue())) {
                cVar.r(true);
            }
        }
    }

    public c(T t) {
        this.b = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c this$0) {
        s.h(this$0, "this$0");
        this$0.r(true);
    }

    public static /* synthetic */ void m(c cVar, d dVar, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBindViewHolder");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        cVar.l(dVar, z);
    }

    public final void a(VH viewHolder, List<? extends Object> list) {
        s.h(viewHolder, "viewHolder");
        this.c = viewHolder;
        if (viewHolder != null) {
            viewHolder.b(this);
        }
        if (list != null && !list.isEmpty()) {
            k(viewHolder, list);
        } else {
            m(this, viewHolder, false, 2, null);
        }
        VH vh = this.c;
        if (vh == null) {
            return;
        }
        View view = vh.itemView;
        s.g(view, "it.itemView");
        us.pinguo.foundation.ui.c.b(view, new Runnable() { // from class: us.pinguo.common.recycler.a.a
            @Override // java.lang.Runnable
            public final void run() {
                c.b(c.this);
            }
        });
    }

    public abstract VH c(ViewGroup viewGroup);

    public final T d() {
        return this.b;
    }

    public final b<T, ?, VH> e() {
        return this.f9945d;
    }

    protected final RecyclerView f() {
        return this.f9946e;
    }

    public final VH g() {
        return this.c;
    }

    public abstract int h();

    public int hashCode() {
        T t = this.b;
        Integer valueOf = t == null ? null : Integer.valueOf(t.hashCode());
        return valueOf == null ? super.hashCode() : valueOf.intValue();
    }

    public final boolean i() {
        return this.a;
    }

    protected final void k(VH viewHolder, List<? extends Object> payloads) {
        s.h(viewHolder, "viewHolder");
        s.h(payloads, "payloads");
    }

    protected abstract void l(VH vh, boolean z);

    public void n() {
    }

    public void o() {
    }

    @Override // us.pinguo.common.recycler.a.d.a
    public void onViewRecycled() {
    }

    public final void p(b<T, ?, VH> bVar) {
        this.f9945d = bVar;
    }

    public final void q(RecyclerView recyclerView) {
        s.h(recyclerView, "recyclerView");
        this.f9946e = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new a(this));
    }

    public final void r(boolean z) {
        if (!this.a && z) {
            o();
        }
        if (this.a && !z) {
            n();
        }
        this.a = z;
    }

    public final void s(T t) {
        this.b = t;
        VH vh = this.c;
        if (vh == null) {
            return;
        }
        l(vh, true);
    }
}
