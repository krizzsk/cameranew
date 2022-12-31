package us.pinguo.common.widget.banner2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
public abstract class BaseBannerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: k  reason: collision with root package name */
    private static final b f9991k = new b();
    private List<? extends T> a;
    private final d b;
    private final AsyncListDiffer<T> c;

    /* renamed from: d  reason: collision with root package name */
    private p<? super BaseBannerAdapter<? extends Object>, ? super Integer, u> f9992d;

    /* renamed from: e  reason: collision with root package name */
    private q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> f9993e;

    /* renamed from: f  reason: collision with root package name */
    private q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> f9994f;

    /* renamed from: g  reason: collision with root package name */
    private q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> f9995g;

    /* renamed from: h  reason: collision with root package name */
    private final q<BaseBannerAdapter<? extends Object>, View, Integer, u> f9996h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9997i;

    /* renamed from: j  reason: collision with root package name */
    private int f9998j;

    /* compiled from: BaseBannerAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class ItemHelper implements View.OnClickListener {
        private final BaseBannerAdapter<? extends Object>.c a;
        private final SparseArray<View> b;
        private BaseBannerAdapter<? extends Object> c;

        /* renamed from: d  reason: collision with root package name */
        private final View f9999d;

        /* renamed from: e  reason: collision with root package name */
        private final Context f10000e;

        /* renamed from: f  reason: collision with root package name */
        private q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> f10001f;

        /* renamed from: g  reason: collision with root package name */
        private a<Object> f10002g;

        public ItemHelper(BaseBannerAdapter<? extends Object>.c viewHolder) {
            s.h(viewHolder, "viewHolder");
            this.a = viewHolder;
            this.b = new SparseArray<>();
            new ArrayList();
            new HashMap();
            View view = viewHolder.itemView;
            s.g(view, "viewHolder.itemView");
            this.f9999d = view;
            Context context = view.getContext();
            s.g(context, "itemView.context");
            this.f10000e = context;
        }

        public final <V extends View> V a(@IdRes int i2) {
            V v = (V) this.b.get(i2);
            if (v == null) {
                v = (V) this.f9999d.findViewById(i2);
                if (v != null) {
                    this.b.put(i2, v);
                } else {
                    String resourceEntryName = this.f9999d.getResources().getResourceEntryName(i2);
                    throw new NullPointerException("id: R.id." + ((Object) resourceEntryName) + " can not find in this item!");
                }
            }
            return v;
        }

        public final BaseBannerAdapter<? extends Object> b() {
            BaseBannerAdapter<? extends Object> baseBannerAdapter = this.c;
            if (baseBannerAdapter != null) {
                return baseBannerAdapter;
            }
            s.z("adapter");
            throw null;
        }

        public final a<Object> c() {
            return this.f10002g;
        }

        public final int d() {
            return this.a.b();
        }

        public final <V extends View> ItemHelper e(@IdRes int i2, l<? super V, u> call) {
            s.h(call, "call");
            call.invoke(a(i2));
            return this;
        }

        public final ItemHelper f(@IdRes int i2, @DrawableRes int i3) {
            e(i2, new BaseBannerAdapter$ItemHelper$setImageResource$1(i3, i2));
            return this;
        }

        public final void g(@LayoutRes int i2) {
        }

        public final void h(q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> onItemChildClickListener) {
            s.h(onItemChildClickListener, "onItemChildClickListener");
            this.f10001f = onItemChildClickListener;
        }

        public final void i(BaseBannerAdapter<? extends Object> RVAdapter) {
            s.h(RVAdapter, "RVAdapter");
            this.c = RVAdapter;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View v) {
            VdsAgent.onClick(this, v);
            s.h(v, "v");
            q<? super BaseBannerAdapter<? extends Object>, ? super View, ? super Integer, u> qVar = this.f10001f;
            if (qVar != null) {
                if (qVar != null) {
                    qVar.invoke(b(), v, Integer.valueOf(d()));
                } else {
                    s.z("mOnItemChildClickListener");
                    throw null;
                }
            }
        }
    }

    /* compiled from: BaseBannerAdapter.kt */
    /* loaded from: classes4.dex */
    public static abstract class a<T> {
        public abstract void a(ItemHelper itemHelper, T t);

        public abstract void b(ItemHelper itemHelper);
    }

    /* compiled from: BaseBannerAdapter.kt */
    /* loaded from: classes4.dex */
    private static final class b implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            s.h(command, "command");
            this.a.post(command);
        }
    }

    /* compiled from: BaseBannerAdapter.kt */
    /* loaded from: classes4.dex */
    public final class c extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private final ItemHelper a;
        private int b;
        final /* synthetic */ BaseBannerAdapter<T> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BaseBannerAdapter this$0, ViewGroup parent, int i2) {
            super(LayoutInflater.from(parent.getContext()).inflate(i2, parent, false));
            s.h(this$0, "this$0");
            s.h(parent, "parent");
            this.c = this$0;
            ItemHelper itemHelper = new ItemHelper(this);
            this.a = itemHelper;
            itemHelper.g(i2);
            itemHelper.h(this$0.o());
            itemHelper.i(this$0);
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
        }

        public final ItemHelper a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final void c(int i2) {
            this.b = i2;
            BaseBannerAdapter<T> baseBannerAdapter = this.c;
            baseBannerAdapter.l(this.a, baseBannerAdapter.m().get(this.b));
            this.c.q(this.b);
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View v) {
            VdsAgent.onClick(this, v);
            s.h(v, "v");
            if (((BaseBannerAdapter) this.c).f9993e != null) {
                q qVar = ((BaseBannerAdapter) this.c).f9993e;
                if (qVar != null) {
                    qVar.invoke(this.c, v, Integer.valueOf(this.b));
                } else {
                    s.z("mOnItemClickListener");
                    throw null;
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            s.h(v, "v");
            if (((BaseBannerAdapter) this.c).f9994f != null) {
                q qVar = ((BaseBannerAdapter) this.c).f9994f;
                if (qVar != null) {
                    qVar.invoke(this.c, v, Integer.valueOf(this.b));
                    return true;
                }
                s.z("mOnItemLongClickListener");
                throw null;
            }
            return false;
        }
    }

    /* compiled from: BaseBannerAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class d extends DiffUtil.ItemCallback<T> {
        final /* synthetic */ BaseBannerAdapter<T> a;

        d(BaseBannerAdapter<T> baseBannerAdapter) {
            this.a = baseBannerAdapter;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(T oldItem, T newItem) {
            s.h(oldItem, "oldItem");
            s.h(newItem, "newItem");
            return this.a.j(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(T oldItem, T newItem) {
            s.h(oldItem, "oldItem");
            s.h(newItem, "newItem");
            return this.a.k(oldItem, newItem);
        }
    }

    public BaseBannerAdapter() {
        List<? extends T> h2;
        h2 = kotlin.collections.u.h();
        this.a = h2;
        d dVar = new d(this);
        this.b = dVar;
        this.c = new AsyncListDiffer<>(this, dVar);
        this.f9996h = new BaseBannerAdapter$mOnItemChildClickListenerProxy$1(this);
        this.f9997i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BaseBannerAdapter this$0) {
        s.h(this$0, "this$0");
        this$0.c.submitList(this$0.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i2) {
        if (this.f9992d == null || !this.f9997i || this.f9998j == getItemCount() || i2 != getItemCount() - 1) {
            return;
        }
        this.f9998j = getItemCount();
        p<? super BaseBannerAdapter<? extends Object>, ? super Integer, u> pVar = this.f9992d;
        if (pVar != null) {
            pVar.invoke(this, Integer.valueOf(getItemCount() - 1));
        } else {
            s.z("mOnLoadMoreListener");
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return m().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return n(i2);
    }

    public boolean j(T oldItem, T newItem) {
        s.h(oldItem, "oldItem");
        s.h(newItem, "newItem");
        return s.c(oldItem, newItem);
    }

    public boolean k(T oldItem, T newItem) {
        s.h(oldItem, "oldItem");
        s.h(newItem, "newItem");
        return oldItem.hashCode() == newItem.hashCode();
    }

    protected abstract void l(ItemHelper itemHelper, T t);

    public List<T> m() {
        List<T> currentList = this.c.getCurrentList();
        s.g(currentList, "mDiffer.currentList");
        return currentList;
    }

    @LayoutRes
    protected abstract int n(int i2);

    public final q<BaseBannerAdapter<? extends Object>, View, Integer, u> o() {
        return this.f9996h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i2) {
        s.h(holder, "holder");
        c cVar = holder instanceof c ? (c) holder : null;
        if (cVar == null) {
            return;
        }
        cVar.c(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        return new c(this, parent, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        s.h(holder, "holder");
        c cVar = holder instanceof c ? (c) holder : null;
        ItemHelper a2 = cVar == null ? null : cVar.a();
        a<Object> c2 = a2 != null ? a2.c() : null;
        if (c2 == null) {
            return;
        }
        c2.b(a2);
    }

    public void r(List<? extends T> value) {
        s.h(value, "value");
        this.f9998j = 0;
        this.f9997i = true;
        this.a = value;
        f9991k.execute(new Runnable() { // from class: us.pinguo.common.widget.banner2.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseBannerAdapter.e(BaseBannerAdapter.this);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i2, List<Object> payloads) {
        s.h(holder, "holder");
        s.h(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i2);
            return;
        }
        c cVar = holder instanceof c ? (c) holder : null;
        ItemHelper a2 = cVar == null ? null : cVar.a();
        a<Object> c2 = a2 != null ? a2.c() : null;
        T t = m().get(i2);
        if (c2 != null) {
            c2.a(a2, t);
        } else {
            onBindViewHolder(holder, i2);
        }
    }
}
