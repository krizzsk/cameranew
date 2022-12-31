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
import java.util.Iterator;
import kotlin.Pair;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.o0;
import us.pinguo.edit2020.view.CircleView;
import us.pinguo.ui.widget.LanFitTextView;
/* compiled from: SkinColorAdapter.kt */
/* loaded from: classes4.dex */
public final class o0 extends RecyclerView.Adapter<a> {
    private kotlin.jvm.b.p<? super us.pinguo.edit2020.bean.m0, ? super Integer, kotlin.u> a;
    private final ArrayList<us.pinguo.edit2020.bean.m0> b = new ArrayList<>();

    /* compiled from: SkinColorAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        private final kotlin.jvm.b.p<us.pinguo.edit2020.bean.m0, Integer, kotlin.u> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, kotlin.jvm.b.p<? super us.pinguo.edit2020.bean.m0, ? super Integer, kotlin.u> pVar) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
            this.a = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a this$0, us.pinguo.edit2020.bean.m0 it, int i2, View view) {
            VdsAgent.lambdaOnClick(view);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(it, "$it");
            kotlin.jvm.b.p<us.pinguo.edit2020.bean.m0, Integer, kotlin.u> pVar = this$0.a;
            if (pVar == null) {
                return;
            }
            pVar.invoke(it, Integer.valueOf(i2));
        }

        public final void a(final us.pinguo.edit2020.bean.m0 model, final int i2) {
            kotlin.jvm.internal.s.h(model, "model");
            if (i2 == 0) {
                View view = this.itemView;
                int i3 = R.id.imgFunctionIcon;
                ((CircleView) view.findViewById(i3)).setCustomDraw(false);
                Drawable drawable = ContextCompat.getDrawable(this.itemView.getContext(), model.d());
                kotlin.jvm.internal.s.e(drawable);
                Drawable wrap = DrawableCompat.wrap(drawable);
                kotlin.jvm.internal.s.g(wrap, "wrap(icon!!)");
                DrawableCompat.setTintList(wrap, ContextCompat.getColorStateList(this.itemView.getContext(), model.h() ? R.color.primary_text_enable : R.color.primary_gray_color));
                ((CircleView) this.itemView.findViewById(i3)).setImageDrawable(wrap);
            } else {
                CircleView circleView = (CircleView) this.itemView.findViewById(R.id.imgFunctionIcon);
                circleView.setCustomDraw(true);
                circleView.setCircleColor(ContextCompat.getColor(this.itemView.getContext(), model.d()));
                circleView.setSelected(model.h());
            }
            if (model.h()) {
                ((LanFitTextView) this.itemView.findViewById(R.id.txtFunctionName)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.primary_text_enable));
            } else {
                ((LanFitTextView) this.itemView.findViewById(R.id.txtFunctionName)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.primary_gray_color));
            }
            ((LanFitTextView) this.itemView.findViewById(R.id.txtFunctionName)).setText(model.c());
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.imgVipIcon);
            kotlin.jvm.internal.s.g(appCompatImageView, "itemView.imgVipIcon");
            int i4 = model.a() ? 0 : 8;
            appCompatImageView.setVisibility(i4);
            VdsAgent.onSetViewVisibility(appCompatImageView, i4);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o0.a.b(o0.a.this, model, i2, view2);
                }
            });
        }
    }

    public final void e(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            f().get(intValue).i(true);
            kotlin.jvm.b.p<us.pinguo.edit2020.bean.m0, Integer, kotlin.u> i2 = i();
            if (i2 != null) {
                us.pinguo.edit2020.bean.m0 m0Var = f().get(intValue);
                kotlin.jvm.internal.s.g(m0Var, "dataList[it]");
                i2.invoke(m0Var, Integer.valueOf(intValue));
            }
        }
        notifyDataSetChanged();
    }

    public final ArrayList<us.pinguo.edit2020.bean.m0> f() {
        return this.b;
    }

    public final us.pinguo.edit2020.bean.m0 g(int i2) {
        us.pinguo.edit2020.bean.m0 m0Var = this.b.get(i2);
        kotlin.jvm.internal.s.g(m0Var, "dataList[position]");
        return m0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public final int h(us.pinguo.edit2020.bean.m0 model) {
        kotlin.jvm.internal.s.h(model, "model");
        Iterator<us.pinguo.edit2020.bean.m0> it = this.b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (kotlin.jvm.internal.s.c(model.f(), it.next().f())) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    public final kotlin.jvm.b.p<us.pinguo.edit2020.bean.m0, Integer, kotlin.u> i() {
        return this.a;
    }

    public final Pair<us.pinguo.edit2020.bean.m0, Integer> j() {
        us.pinguo.edit2020.bean.m0 m0Var;
        Iterator<us.pinguo.edit2020.bean.m0> it = this.b.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                m0Var = null;
                i2 = -1;
                break;
            }
            int i3 = i2 + 1;
            m0Var = it.next();
            if (m0Var.h()) {
                break;
            }
            i2 = i3;
        }
        return new Pair<>(m0Var, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        us.pinguo.edit2020.bean.m0 m0Var = this.b.get(i2);
        kotlin.jvm.internal.s.g(m0Var, "dataList[position]");
        holder.a(m0Var, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skin_color_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…           parent, false)");
        return new a(inflate, this.a);
    }

    public final void m(ArrayList<us.pinguo.edit2020.bean.m0> list, Integer num) {
        kotlin.jvm.internal.s.h(list, "list");
        this.b.clear();
        this.b.addAll(list);
        e(num);
    }

    public final void n(kotlin.jvm.b.p<? super us.pinguo.edit2020.bean.m0, ? super Integer, kotlin.u> pVar) {
        this.a = pVar;
    }

    public final void o(int i2) {
        us.pinguo.edit2020.bean.m0 first = j().getFirst();
        if (first != null) {
            first.i(false);
        }
        this.b.get(i2).i(true);
        notifyItemRangeChanged(0, this.b.size());
    }
}
