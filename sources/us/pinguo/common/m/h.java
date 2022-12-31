package us.pinguo.common.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.abtest.Plan;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.commonui.R;
import us.pinguo.foundation.statistics.i;
import us.pinguo.repository2020.entity.StyleMakeup;
/* compiled from: StyleMakeupAdapter.kt */
/* loaded from: classes4.dex */
public final class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements e {
    private List<StyleMakeup> a;
    private int b;
    private ObservableBoolean c;

    /* renamed from: d  reason: collision with root package name */
    private ObservableBoolean f9938d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9939e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9940f;

    /* renamed from: g  reason: collision with root package name */
    private b f9941g;

    /* compiled from: StyleMakeupAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
        }
    }

    /* compiled from: StyleMakeupAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void f(View view, StyleMakeup styleMakeup, boolean z);
    }

    public h(List<StyleMakeup> styleMakeupList, boolean z, boolean z2) {
        s.h(styleMakeupList, "styleMakeupList");
        int i2 = -1;
        this.b = -1;
        int i3 = 0;
        this.c = new ObservableBoolean(false);
        this.f9938d = new ObservableBoolean(true);
        this.a = styleMakeupList;
        this.f9939e = z;
        this.f9940f = z2;
        if (!z) {
            Iterator<StyleMakeup> it = styleMakeupList.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ObservableBoolean isSelected = it.next().isSelected();
                if (isSelected != null && isSelected.get()) {
                    i2 = i4;
                    break;
                }
                i4++;
            }
            i3 = i2;
        }
        this.b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0, Ref$IntRef positionTemp, RecyclerView.ViewHolder holder, StyleMakeup styleMakeup, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(positionTemp, "$positionTemp");
        s.h(holder, "$holder");
        s.h(styleMakeup, "$styleMakeup");
        int i2 = this$0.b;
        if (i2 == positionTemp.element) {
            ObservableBoolean isSelected = this$0.a.get(i2).isSelected();
            if (isSelected != null && isSelected.get()) {
                return;
            }
        }
        b bVar = this$0.f9941g;
        if (bVar != null) {
            bVar.f(holder.itemView, styleMakeup, this$0.b > positionTemp.element);
        }
        this$0.b = positionTemp.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(h this$0, Ref$IntRef positionTemp, View view) {
        int i2;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(positionTemp, "$positionTemp");
        if (this$0.b == positionTemp.element || this$0.f9938d.get() || (i2 = this$0.b) <= 0) {
            return;
        }
        ObservableBoolean isSelected = this$0.a.get(i2 - 1).isSelected();
        if (isSelected != null) {
            isSelected.set(false);
        }
        b bVar = this$0.f9941g;
        if (bVar != null) {
            bVar.a();
        }
        this$0.b = positionTemp.element;
    }

    @Override // us.pinguo.common.m.e
    public void d(boolean z) {
        this.c.set(z);
    }

    public final ObservableBoolean e() {
        return this.f9938d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9939e ? this.a.size() + 1 : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.f9939e && i2 == 0) ? 1 : 2;
    }

    public final void j(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.f9938d = observableBoolean;
    }

    public final void k(int i2) {
        this.b = i2;
    }

    public final void l(b onStyleMakeupItemClick) {
        s.h(onStyleMakeupItemClick, "onStyleMakeupItemClick");
        this.f9941g = onStyleMakeupItemClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int i2) {
        s.h(holder, "holder");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i2;
        if (i2 < 0) {
            return;
        }
        if (holder instanceof a) {
            if (this.f9939e) {
                ref$IntRef.element = i2 - 1;
            }
            final StyleMakeup styleMakeup = this.a.get(ref$IntRef.element);
            styleMakeup.setDark(this.c);
            i iVar = us.pinguo.foundation.statistics.h.b;
            iVar.r0("camera_page", styleMakeup.getPid(), "show");
            Plan icon_ab = styleMakeup.getIcon_ab();
            if (icon_ab != null) {
                if (!s.c(icon_ab.getGid(), "gid_default")) {
                    if (!s.c(icon_ab.getTid(), "tid_default")) {
                        String gid = icon_ab.getGid();
                        String str = gid != null ? gid : "gid_default";
                        String str2 = styleMakeup.getEditMakeupCurrentValues() != null ? "edit_page" : "camera_page";
                        String tid = icon_ab.getTid();
                        iVar.D(str, str2, tid != null ? tid : "tid_default", "show");
                    }
                }
            }
            us.pinguo.commonui.b.c cVar = (us.pinguo.commonui.b.c) DataBindingUtil.findBinding(holder.itemView);
            if (cVar != null) {
                cVar.b(styleMakeup);
            }
            if (cVar != null) {
                cVar.a(Boolean.valueOf(this.f9940f));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.m.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.h(h.this, ref$IntRef, holder, styleMakeup, view);
                }
            });
        } else if (holder instanceof f) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.m.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.i(h.this, ref$IntRef, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        if (i2 == 1) {
            us.pinguo.commonui.b.e bing = (us.pinguo.commonui.b.e) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_style_makeup_none, parent, false);
            bing.a(this.f9938d);
            s.g(bing, "bing");
            return new f(bing);
        }
        View root = ((us.pinguo.commonui.b.c) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_style_makeup, parent, false)).getRoot();
        s.g(root, "inflate<ItemStyleMakeupB…keup, parent, false).root");
        return new a(root);
    }

    public /* synthetic */ h(List list, boolean z, boolean z2, int i2, o oVar) {
        this(list, z, (i2 & 4) != 0 ? false : z2);
    }
}
