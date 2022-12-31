package us.pinguo.edit2020.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.CircleView;
import us.pinguo.ui.widget.LanFitTextView;
/* compiled from: NewSkinColorAdapter.kt */
/* loaded from: classes4.dex */
public final class k0 extends RecyclerView.Adapter<a> {
    private kotlin.jvm.b.q<? super Integer, ? super Integer, ? super us.pinguo.edit2020.bean.i, kotlin.u> b;
    private int a = -1;
    private final ArrayList<us.pinguo.edit2020.bean.i> c = new ArrayList<>();

    /* compiled from: NewSkinColorAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(k0 this$0, int i2, us.pinguo.edit2020.bean.i it, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "$it");
        int i3 = this$0.a;
        this$0.a = i2;
        this$0.notifyItemRangeChanged(0, this$0.getItemCount());
        kotlin.jvm.b.q<? super Integer, ? super Integer, ? super us.pinguo.edit2020.bean.i, kotlin.u> qVar = this$0.b;
        if (qVar == null) {
            return;
        }
        qVar.invoke(Integer.valueOf(i3), Integer.valueOf(i2), it);
    }

    public final boolean e(int i2) {
        return this.a == i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        final us.pinguo.edit2020.bean.i iVar = this.c.get(i2);
        if (i2 == 0) {
            View view = holder.itemView;
            int i3 = R.id.imgFunctionIcon;
            ((CircleView) view.findViewById(i3)).setCustomDraw(false);
            Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), iVar.d());
            kotlin.jvm.internal.s.e(drawable);
            Drawable wrap = DrawableCompat.wrap(drawable);
            kotlin.jvm.internal.s.g(wrap, "wrap(icon!!)");
            DrawableCompat.setTintList(wrap, ContextCompat.getColorStateList(holder.itemView.getContext(), e(i2) ? R.color.primary_text_enable : R.color.primary_gray_color));
            ((CircleView) holder.itemView.findViewById(i3)).setImageDrawable(wrap);
        } else {
            CircleView circleView = (CircleView) holder.itemView.findViewById(R.id.imgFunctionIcon);
            circleView.setCustomDraw(true);
            circleView.setCircleColor(ContextCompat.getColor(holder.itemView.getContext(), iVar.d()));
            circleView.setSelected(e(i2));
        }
        if (e(i2)) {
            ((LanFitTextView) holder.itemView.findViewById(R.id.txtFunctionName)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primary_text_enable));
        } else {
            ((LanFitTextView) holder.itemView.findViewById(R.id.txtFunctionName)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primary_gray_color));
        }
        ((LanFitTextView) holder.itemView.findViewById(R.id.txtFunctionName)).setText(iVar.c());
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.itemView.findViewById(R.id.imgVipIcon);
        kotlin.jvm.internal.s.g(appCompatImageView, "holder.itemView.imgVipIcon");
        int i4 = iVar.a() ? 0 : 8;
        appCompatImageView.setVisibility(i4);
        VdsAgent.onSetViewVisibility(appCompatImageView, i4);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.h(k0.this, i2, iVar, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skin_color_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…rent, false\n            )");
        return new a(inflate);
    }

    public final void j(List<us.pinguo.edit2020.bean.i> list, int i2) {
        kotlin.jvm.b.q<? super Integer, ? super Integer, ? super us.pinguo.edit2020.bean.i, kotlin.u> qVar;
        kotlin.jvm.internal.s.h(list, "list");
        this.c.clear();
        this.c.addAll(list);
        this.a = i2;
        boolean z = false;
        notifyItemRangeChanged(0, list.size());
        if (i2 >= 0 && i2 < getItemCount()) {
            z = true;
        }
        if (!z || (qVar = this.b) == null) {
            return;
        }
        qVar.invoke(-1, Integer.valueOf(i2), list.get(i2));
    }

    public final void k(kotlin.jvm.b.q<? super Integer, ? super Integer, ? super us.pinguo.edit2020.bean.i, kotlin.u> qVar) {
        this.b = qVar;
    }
}
