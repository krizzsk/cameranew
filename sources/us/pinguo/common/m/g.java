package us.pinguo.common.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* compiled from: SelfDefMakeupAdapter.kt */
/* loaded from: classes4.dex */
public final class g<T extends SelfDefMakeupMaterial> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements e {
    private List<? extends T> b;

    /* renamed from: f  reason: collision with root package name */
    private a f9937f;
    private boolean a = true;
    private int c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ObservableBoolean f9935d = new ObservableBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private final ObservableBoolean f9936e = new ObservableBoolean(true);

    /* compiled from: SelfDefMakeupAdapter.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b(View view, SelfDefMakeupMaterial selfDefMakeupMaterial);
    }

    /* compiled from: SelfDefMakeupAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {
        private final us.pinguo.commonui.b.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(us.pinguo.commonui.b.a binding) {
            super(binding.getRoot());
            s.h(binding, "binding");
            this.a = binding;
        }

        public final us.pinguo.commonui.b.a a() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(g this$0, Ref$IntRef positionTemp, RecyclerView.ViewHolder holder, int i2, View view) {
        T t;
        ObservableBoolean isSelected;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(positionTemp, "$positionTemp");
        s.h(holder, "$holder");
        int i3 = this$0.c;
        if (i3 == positionTemp.element) {
            List<? extends T> list = this$0.b;
            if ((list == null || (t = list.get(i3)) == null || (isSelected = t.isSelected()) == null || !isSelected.get()) ? false : true) {
                return;
            }
        }
        a aVar = this$0.f9937f;
        if (aVar != null) {
            View view2 = holder.itemView;
            List<? extends T> list2 = this$0.b;
            aVar.b(view2, list2 == null ? null : list2.get(positionTemp.element));
        }
        this$0.c = i2;
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(g this$0, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        a aVar = this$0.f9937f;
        if (aVar != null) {
            aVar.a();
        }
        this$0.c = i2;
        this$0.f9936e.set(true);
    }

    @Override // us.pinguo.common.m.e
    public void d(boolean z) {
        this.f9935d.set(z);
    }

    public final ObservableBoolean e() {
        return this.f9936e;
    }

    public final boolean f() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.b;
        int size = list == null ? 0 : list.size();
        return this.a ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.a && i2 == 0) ? 1 : 2;
    }

    public final void k(List<? extends T> list) {
        int i2;
        ObservableBoolean isSelected;
        this.b = list;
        int i3 = 0;
        if (list != null) {
            Iterator<? extends T> it = list.iterator();
            i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                T next = it.next();
                if ((next == null || (isSelected = next.isSelected()) == null || !isSelected.get()) ? false : true) {
                    break;
                }
                i2++;
            }
        } else {
            i2 = 0;
        }
        if (i2 != -1 || !this.a) {
            i3 = i2 + 1;
        }
        this.c = i3;
        notifyDataSetChanged();
    }

    public final void l(a onSelfDefMakeupItemClick) {
        s.h(onSelfDefMakeupItemClick, "onSelfDefMakeupItemClick");
        this.f9937f = onSelfDefMakeupItemClick;
    }

    public final void m(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i2) {
        s.h(holder, "holder");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i2;
        if (i2 < 0) {
            return;
        }
        if (holder instanceof b) {
            if (this.a) {
                ref$IntRef.element = i2 - 1;
            }
            List<? extends T> list = this.b;
            T t = list == null ? null : list.get(ref$IntRef.element);
            if (t != null) {
                t.setDark(this.f9935d);
            }
            b bVar = (b) holder;
            us.pinguo.commonui.b.a a2 = bVar.a();
            if (a2 != null) {
                List<? extends T> list2 = this.b;
                a2.b(list2 != null ? list2.get(ref$IntRef.element) : null);
            }
            us.pinguo.commonui.b.a a3 = bVar.a();
            if (a3 != null) {
                a3.a(Boolean.TRUE);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.m.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.i(g.this, ref$IntRef, holder, i2, view);
                }
            });
            bVar.a().executePendingBindings();
        } else if (holder instanceof f) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.m.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.j(g.this, i2, view);
                }
            });
            ((f) holder).a().executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        if (i2 == 1) {
            us.pinguo.commonui.b.e bing = (us.pinguo.commonui.b.e) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_style_makeup_none, parent, false);
            bing.a(this.f9936e);
            s.g(bing, "bing");
            return new f(bing);
        }
        us.pinguo.commonui.b.a binding = (us.pinguo.commonui.b.a) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_selfdef_makeup, parent, false);
        s.g(binding, "binding");
        return new b(binding);
    }
}
