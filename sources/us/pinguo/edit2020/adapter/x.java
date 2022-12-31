package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.g;
/* compiled from: CircleColorAdapter.kt */
/* loaded from: classes4.dex */
public final class x<T extends us.pinguo.edit2020.bean.g> extends RecyclerView.Adapter<z> {
    private final ArrayList<T> a;
    private kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10157d;

    public x(ArrayList<T> colors) {
        kotlin.jvm.internal.s.h(colors, "colors");
        this.a = colors;
        this.c = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(x this$0, int i2, us.pinguo.edit2020.bean.g detail, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(detail, "$detail");
        int i3 = this$0.f10157d;
        if (i3 == i2) {
            return;
        }
        this$0.f10157d = i2;
        this$0.notifyItemChanged(i3);
        this$0.notifyItemChanged(i2);
        kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar = this$0.b;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), detail);
    }

    public final kotlin.jvm.b.p<Integer, T, kotlin.u> e() {
        return (kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u>) this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(z holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        T t = this.a.get(i2);
        kotlin.jvm.internal.s.g(t, "colors[position]");
        final T t2 = t;
        Context context = holder.itemView.getContext();
        holder.a().setEnableRing(i2 == this.f10157d || t2.c() == this.c);
        if (holder.a().a()) {
            if (i2 == this.f10157d && t2.c() == this.c) {
                holder.a().setRingWidth(context.getResources().getDimension(R.dimen.circle_color_ring_stroke_width) * 2.0f);
            } else if (i2 == this.f10157d) {
                holder.a().setRingWidth(context.getResources().getDimension(R.dimen.circle_color_ring_stroke_width));
            } else {
                holder.a().setRingWidth(context.getResources().getDimension(R.dimen.circle_color_individual_ring_width));
            }
        }
        if (t2.c() == this.c) {
            holder.a().setIndividualRingColor(Integer.valueOf(Color.parseColor("#eeeeee")));
        } else {
            holder.a().setIndividualRingColor(null);
        }
        holder.a().setColor(t2.c());
        holder.a().setEnableHalf(t2.a());
        if (t2.a()) {
            holder.a().setLeftHalfColor(t2.b());
            holder.a().setRightHalfColor(t2.d());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.h(x.this, i2, t2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public z onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.layout_circle_color_item, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(Foundation.getAppCo…olor_item, parent, false)");
        return new z(inflate);
    }

    public final void j(int i2) {
        int i3 = this.f10157d;
        if (i2 == i3) {
            return;
        }
        this.f10157d = i2;
        notifyItemChanged(i3);
        notifyItemChanged(i2);
    }

    public final void k(kotlin.jvm.b.p<? super Integer, ? super T, kotlin.u> pVar) {
        this.b = pVar;
    }
}
