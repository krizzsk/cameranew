package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Set;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.p0;
/* compiled from: SkinRefreshManualAdapter.kt */
/* loaded from: classes4.dex */
public final class p0 extends a0<us.pinguo.edit2020.bean.n0> {

    /* renamed from: i  reason: collision with root package name */
    private boolean f10139i;

    /* compiled from: SkinRefreshManualAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends b0 {

        /* renamed from: g  reason: collision with root package name */
        private final AppCompatImageView f10140g;

        /* renamed from: h  reason: collision with root package name */
        private final View f10141h;

        /* renamed from: i  reason: collision with root package name */
        private final View f10142i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.imgEraIcon);
            kotlin.jvm.internal.s.g(appCompatImageView, "itemView.imgEraIcon");
            this.f10140g = appCompatImageView;
            TextView textView = (TextView) itemView.findViewById(R.id.divider);
            kotlin.jvm.internal.s.g(textView, "itemView.divider");
            this.f10141h = textView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R.id.imgVipIcon);
            kotlin.jvm.internal.s.g(appCompatImageView2, "itemView.imgVipIcon");
            this.f10142i = appCompatImageView2;
        }

        public final View g() {
            return this.f10141h;
        }

        public final AppCompatImageView h() {
            return this.f10140g;
        }

        public final View i() {
            return this.f10142i;
        }
    }

    private final void F(final a aVar, int i2) {
        long j2 = !kotlin.jvm.internal.s.c(aVar.h().getTag(), Integer.valueOf(i2)) ? 0L : 200L;
        View g2 = aVar.g();
        g2.setVisibility(8);
        VdsAgent.onSetViewVisibility(g2, 8);
        ViewPropertyAnimator animate = aVar.a().animate();
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        animate.translationX(us.pinguo.util.g.a(b, 0.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
        ViewPropertyAnimator animate2 = aVar.i().animate();
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        animate2.translationX(us.pinguo.util.g.a(b2, 0.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
        ViewPropertyAnimator animate3 = aVar.h().animate();
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        animate3.translationX(-us.pinguo.util.g.a(b3, 0.0f)).alpha(0.0f).setDuration(j2).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.adapter.p
            @Override // java.lang.Runnable
            public final void run() {
                p0.G(p0.a.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(a holder) {
        kotlin.jvm.internal.s.h(holder, "$holder");
        AppCompatImageView h2 = holder.h();
        h2.setVisibility(8);
        VdsAgent.onSetViewVisibility(h2, 8);
        holder.h().setAlpha(1.0f);
    }

    private final boolean H(us.pinguo.edit2020.bean.n0 n0Var) {
        return kotlin.jvm.internal.s.c(n0Var.f(), "qudou") || kotlin.jvm.internal.s.c(n0Var.f(), "quzhouwen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(p0 this$0, int i2, us.pinguo.edit2020.bean.n0 function, b0 holder, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.internal.s.h(holder, "$holder");
        if (this$0.l() == i2) {
            if (this$0.H(function)) {
                return;
            }
            this$0.f10139i = !this$0.f10139i;
            this$0.notifyItemChanged(i2);
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n0, kotlin.u> j2 = this$0.j();
            if (j2 == null) {
                return;
            }
            if (this$0.f10139i) {
                i2 = -2;
            }
            j2.invoke(Integer.valueOf(i2), function);
            return;
        }
        Set<Integer> m = this$0.m();
        if (m != null && m.contains(Integer.valueOf(i2))) {
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n0, kotlin.u> j3 = this$0.j();
            if (j3 == null) {
                return;
            }
            j3.invoke(Integer.valueOf(i2), function);
            return;
        }
        this$0.f10139i = false;
        int l2 = this$0.l();
        this$0.B(i2);
        a aVar = (a) holder;
        this$0.L(aVar, i2);
        this$0.M(aVar, 200L, function);
        if (l2 >= 0) {
            this$0.notifyItemChanged(l2);
        }
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n0, kotlin.u> j4 = this$0.j();
        if (j4 == null) {
            return;
        }
        j4.invoke(Integer.valueOf(i2), function);
    }

    private final void L(a aVar, int i2) {
        us.pinguo.edit2020.bean.n0 n0Var = h().get(i2);
        kotlin.jvm.internal.s.g(n0Var, "dataList[position]");
        us.pinguo.edit2020.bean.n0 n0Var2 = n0Var;
        aVar.a().setImageResource(n0Var2.d());
        aVar.c().setText(n0Var2.c());
        AppCompatImageView b = aVar.b();
        int i3 = n0Var2.a() ^ true ? 4 : 0;
        b.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b, i3);
        AppCompatImageView e2 = aVar.e();
        int i4 = n0Var2.e() ^ true ? 4 : 0;
        e2.setVisibility(i4);
        VdsAgent.onSetViewVisibility(e2, i4);
        if (this.f10139i) {
            us.pinguo.foundation.utils.q qVar = us.pinguo.foundation.utils.q.a;
            Context context = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context, "holder.imgIcon.context");
            qVar.a(context, R.color.edit_function_select, R.drawable.icon_beauty_skinrefresh_xiangpica, aVar.h());
            Context context2 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context2, "holder.imgIcon.context");
            qVar.a(context2, R.color.edit_function_unselect, n0Var2.d(), aVar.a());
        } else {
            us.pinguo.foundation.utils.q qVar2 = us.pinguo.foundation.utils.q.a;
            Context context3 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context3, "holder.imgIcon.context");
            int i5 = R.color.edit_function_unselect;
            qVar2.a(context3, i5, R.drawable.icon_beauty_skinrefresh_xiangpica, aVar.h());
            if (l() == i2) {
                Context context4 = aVar.a().getContext();
                kotlin.jvm.internal.s.g(context4, "holder.imgIcon.context");
                qVar2.a(context4, R.color.edit_function_select, n0Var2.d(), aVar.a());
            } else {
                Context context5 = aVar.a().getContext();
                kotlin.jvm.internal.s.g(context5, "holder.imgIcon.context");
                qVar2.a(context5, i5, n0Var2.d(), aVar.a());
            }
        }
        if (l() == i2) {
            aVar.c().setTextColor(ContextCompat.getColor(aVar.a().getContext(), R.color.edit_function_select));
            aVar.e().setImageResource(R.drawable.dot_selected);
            return;
        }
        aVar.c().setTextColor(ContextCompat.getColor(aVar.a().getContext(), R.color.edit_function_unselect));
        aVar.e().setImageResource(R.drawable.dot_unselect);
    }

    private final void M(a aVar, long j2, us.pinguo.edit2020.bean.n0 n0Var) {
        if (H(n0Var)) {
            return;
        }
        AppCompatImageView h2 = aVar.h();
        h2.setVisibility(0);
        VdsAgent.onSetViewVisibility(h2, 0);
        View g2 = aVar.g();
        g2.setVisibility(0);
        VdsAgent.onSetViewVisibility(g2, 0);
        ViewPropertyAnimator animate = aVar.a().animate();
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        animate.translationX(-us.pinguo.util.g.a(b, 17.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
        ViewPropertyAnimator animate2 = aVar.i().animate();
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        animate2.translationX(-us.pinguo.util.g.a(b2, 17.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
        ViewPropertyAnimator animate3 = aVar.h().animate();
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        animate3.translationX(us.pinguo.util.g.a(b3, 17.0f)).setDuration(j2).start();
    }

    @Override // us.pinguo.edit2020.adapter.a0, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(final b0 holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        us.pinguo.edit2020.bean.n0 n0Var = h().get(i2);
        kotlin.jvm.internal.s.g(n0Var, "dataList[position]");
        final us.pinguo.edit2020.bean.n0 n0Var2 = n0Var;
        if (holder instanceof a) {
            a aVar = (a) holder;
            L(aVar, i2);
            if (l() == i2) {
                M(aVar, 0L, n0Var2);
            } else {
                F(aVar, i2);
            }
            aVar.h().setTag(Integer.valueOf(i2));
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p0.K(p0.this, i2, n0Var2, holder, view);
                }
            });
        }
    }

    @Override // us.pinguo.edit2020.adapter.a0, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public b0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_function_double_item_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new a(inflate);
    }

    @Override // us.pinguo.edit2020.adapter.a0
    public void s(Integer num) {
        boolean z;
        Set<Integer> m = m();
        boolean z2 = false;
        if (m != null) {
            z = kotlin.collections.c0.z(m, num);
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            B(num == null ? -1 : num.intValue());
        }
        notifyDataSetChanged();
        if (num == null) {
            return;
        }
        num.intValue();
        if (this.f10139i) {
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n0, kotlin.u> j2 = j();
            if (j2 == null) {
                return;
            }
            us.pinguo.edit2020.bean.n0 n0Var = h().get(num.intValue());
            kotlin.jvm.internal.s.g(n0Var, "dataList[selected]");
            j2.invoke(-2, n0Var);
            return;
        }
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n0, kotlin.u> j3 = j();
        if (j3 == null) {
            return;
        }
        us.pinguo.edit2020.bean.n0 n0Var2 = h().get(num.intValue());
        kotlin.jvm.internal.s.g(n0Var2, "dataList[selected]");
        j3.invoke(num, n0Var2);
    }

    @Override // us.pinguo.edit2020.adapter.a0
    public void w() {
        this.f10139i = false;
    }
}
