package us.pinguo.camera2020.view.adapter;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import us.pinguo.camera2020.R;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.repository2020.database.sticker.StickerState;
import us.pinguo.repository2020.entity.Material;
/* compiled from: StickerRecyclerAdapter.kt */
/* loaded from: classes3.dex */
public final class u extends RecyclerView.Adapter<v> {
    private List<Sticker> a;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f9376d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9377e;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.jvm.b.p<? super Integer, ? super String, kotlin.u> f9379g;
    private HashMap<String, Integer> b = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private int f9378f = -1;

    public u(boolean z) {
        this.f9377e = z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(u this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.p<? super Integer, ? super String, kotlin.u> pVar = this$0.f9379g;
        if (pVar == null) {
            return;
        }
        pVar.invoke(0, Material.MATERIAL_DUSTBIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(u this$0, int i2, Sticker sticker, View view) {
        kotlin.jvm.b.p<? super Integer, ? super String, kotlin.u> pVar;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(sticker, "$sticker");
        this$0.f9376d = null;
        if (i2 == this$0.f9378f || (pVar = this$0.f9379g) == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), sticker.getPid());
    }

    public static /* synthetic */ void r(u uVar, String str, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        uVar.q(str, num);
    }

    public final void e() {
        this.f9376d = null;
        int i2 = this.f9378f;
        if (i2 == -1) {
            return;
        }
        this.f9378f = -1;
        if (i2 >= this.f9377e) {
            notifyItemChanged(i2);
        }
    }

    public final int f(String id) {
        kotlin.jvm.internal.s.h(id, "id");
        List<Sticker> list = this.a;
        int i2 = -1;
        if (list == null) {
            return -1;
        }
        int i3 = this.f9377e;
        int i4 = 0;
        Iterator<Sticker> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (kotlin.jvm.internal.s.c(id, it.next().getPid())) {
                i2 = i4;
                break;
            } else {
                i4++;
            }
        }
        return i3 + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i2 = this.f9377e;
        List<Sticker> list = this.a;
        return i2 + (list == null ? 0 : list.size());
    }

    public final void i(String id, int i2, int i3) {
        kotlin.jvm.internal.s.h(id, "id");
        this.b.put(id, Integer.valueOf(i3));
        notifyItemChanged(i2 + this.f9377e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(v holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        int i3 = this.f9377e;
        int i4 = 0;
        if (i3 != 0 && i2 == 0) {
            ImageView a = holder.a();
            a.setVisibility(8);
            VdsAgent.onSetViewVisibility(a, 8);
            FilterPackageDownloadView e2 = holder.e();
            e2.setVisibility(8);
            VdsAgent.onSetViewVisibility(e2, 8);
            ImageView b = holder.b();
            b.setVisibility(8);
            VdsAgent.onSetViewVisibility(b, 8);
            View f2 = holder.f();
            f2.setVisibility(8);
            VdsAgent.onSetViewVisibility(f2, 8);
            ImageView d2 = holder.d();
            d2.setVisibility(8);
            VdsAgent.onSetViewVisibility(d2, 8);
            holder.c().setImageResource(R.drawable.ic_sticker_dustbin);
            TypedArray obtainStyledAttributes = holder.d().getContext().getTheme().obtainStyledAttributes(new int[]{16843868});
            kotlin.jvm.internal.s.g(obtainStyledAttributes, "holder.imgVipIcon.contex…temBackgroundBorderless))");
            holder.itemView.setBackground(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.adapter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.k(u.this, view);
                }
            });
            return;
        }
        int i5 = this.c ? R.drawable.sticker_item_selection_dark : R.drawable.sticker_item_selection_light;
        List<Sticker> list = this.a;
        final Sticker sticker = list == null ? null : list.get(i2 - i3);
        if (sticker == null) {
            return;
        }
        StickerState state = sticker.getState();
        ImageView a2 = holder.a();
        int i6 = (state == StickerState.NOT_DOWNLOADED || state == null) && !StickerManager.a.U(sticker.getPid()) ? 0 : 8;
        a2.setVisibility(i6);
        VdsAgent.onSetViewVisibility(a2, i6);
        FilterPackageDownloadView e3 = holder.e();
        StickerState stickerState = StickerState.DOWNLOADING;
        int i7 = state == stickerState ? 0 : 8;
        e3.setVisibility(i7);
        VdsAgent.onSetViewVisibility(e3, i7);
        if (state == stickerState) {
            Integer num = this.b.get(sticker.getPid());
            if (num != null) {
                holder.e().setDownloadProgress(num.intValue());
            }
        } else {
            holder.e().setDownloadProgress(0);
        }
        ImageView b2 = holder.b();
        int i8 = sticker.isMusic() ? 0 : 8;
        b2.setVisibility(i8);
        VdsAgent.onSetViewVisibility(b2, i8);
        ImageView d3 = holder.d();
        int i9 = sticker.isVip() ? 0 : 8;
        d3.setVisibility(i9);
        VdsAgent.onSetViewVisibility(d3, i9);
        View f3 = holder.f();
        int i10 = sticker.isFresh() ? 0 : 8;
        f3.setVisibility(i10);
        VdsAgent.onSetViewVisibility(f3, i10);
        holder.c().setImageURI(sticker.getIcon());
        View view = holder.itemView;
        if (i2 == this.f9378f && state == StickerState.AVAILABLE) {
            i4 = i5;
        }
        view.setBackgroundResource(i4);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.l(u.this, i2, sticker, view2);
            }
        });
        if (kotlin.jvm.internal.s.c(this.f9376d, sticker.getPid())) {
            this.f9376d = null;
            holder.itemView.performClick();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public v onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sticker_item_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new v(inflate);
    }

    public final void n(List<Sticker> data) {
        kotlin.jvm.internal.s.h(data, "data");
        this.a = data;
        notifyDataSetChanged();
    }

    public final Integer o(String id) {
        kotlin.jvm.internal.s.h(id, "id");
        return this.b.remove(id);
    }

    public final void p(String str) {
        List<Sticker> list;
        boolean z;
        if (kotlin.jvm.internal.s.c(str, this.f9376d) || (list = this.a) == null || list.isEmpty()) {
            return;
        }
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Sticker sticker : list) {
                if (kotlin.jvm.internal.s.c(str, sticker.getPid())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            str = list.get(0).getPid();
        }
        this.f9376d = str;
    }

    public final void q(String str, Integer num) {
        Integer valueOf;
        if (str == null) {
            e();
            return;
        }
        int i2 = this.f9377e;
        List<Sticker> list = this.a;
        if (list == null) {
            valueOf = null;
        } else {
            int i3 = 0;
            Iterator<Sticker> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (kotlin.jvm.internal.s.c(str, it.next().getPid())) {
                    break;
                } else {
                    i3++;
                }
            }
            valueOf = Integer.valueOf(i3);
        }
        if (valueOf == null) {
            return;
        }
        int intValue = i2 + valueOf.intValue();
        if (intValue < this.f9377e) {
            if (num != null && num.intValue() >= this.f9377e) {
                intValue = num.intValue();
            } else {
                e();
                return;
            }
        }
        int i4 = this.f9378f;
        if (intValue == i4) {
            return;
        }
        this.f9378f = intValue;
        if (i4 >= this.f9377e) {
            notifyItemChanged(i4);
        }
        notifyItemChanged(intValue);
    }

    public final void s(boolean z) {
        this.c = z;
        if (this.f9377e > 0) {
            notifyItemChanged(0);
        }
        int i2 = this.f9378f;
        if (i2 > 0) {
            notifyItemChanged(i2);
        }
    }

    public final void t(kotlin.jvm.b.p<? super Integer, ? super String, kotlin.u> pVar) {
        this.f9379g = pVar;
    }
}
