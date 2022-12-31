package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.p0;
/* compiled from: NewSkinRefreshAdapter.kt */
/* loaded from: classes4.dex */
public final class l0 extends a0<us.pinguo.edit2020.bean.i> {

    /* renamed from: i  reason: collision with root package name */
    private final String f10134i = "qudou";

    /* renamed from: j  reason: collision with root package name */
    private final String f10135j = "quzhouwen";

    /* renamed from: k  reason: collision with root package name */
    private boolean f10136k;

    private final void F(final p0.a aVar, int i2) {
        long j2 = !kotlin.jvm.internal.s.c(aVar.h().getTag(), Integer.valueOf(i2)) ? 0L : 200L;
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
        animate3.translationX(-us.pinguo.util.g.a(b3, 0.0f)).alpha(0.0f).setDuration(j2).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.adapter.l
            @Override // java.lang.Runnable
            public final void run() {
                l0.H(p0.a.this);
            }
        }).start();
    }

    static /* synthetic */ void G(l0 l0Var, p0.a aVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        l0Var.F(aVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(p0.a holder) {
        kotlin.jvm.internal.s.h(holder, "$holder");
        AppCompatImageView h2 = holder.h();
        h2.setVisibility(8);
        VdsAgent.onSetViewVisibility(h2, 8);
        View g2 = holder.g();
        g2.setVisibility(8);
        VdsAgent.onSetViewVisibility(g2, 8);
        holder.h().setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(us.pinguo.edit2020.bean.i function, l0 this$0, int i2, b0 holder, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        if (function.j() && this$0.l() == i2 && !kotlin.jvm.internal.s.c(function.f(), this$0.f10135j) && !kotlin.jvm.internal.s.c(function.f(), this$0.f10134i)) {
            function.l(!function.k());
            this$0.notifyItemChanged(i2);
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.i, kotlin.u> j2 = this$0.j();
            if (j2 == null) {
                return;
            }
            if (function.k()) {
                i2 = -2;
            }
            j2.invoke(Integer.valueOf(i2), function);
            return;
        }
        int l2 = this$0.l();
        this$0.B(i2);
        p0.a aVar = (p0.a) holder;
        this$0.L(aVar, i2);
        if (function.j()) {
            this$0.N(aVar, 200L, function);
        }
        if (l2 >= 0) {
            this$0.notifyItemChanged(l2);
        }
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.i, kotlin.u> j3 = this$0.j();
        if (j3 == null) {
            return;
        }
        j3.invoke(Integer.valueOf(i2), function);
    }

    private final void L(p0.a aVar, int i2) {
        us.pinguo.edit2020.bean.i iVar = h().get(i2);
        kotlin.jvm.internal.s.g(iVar, "dataList[position]");
        us.pinguo.edit2020.bean.i iVar2 = iVar;
        aVar.a().setImageResource(iVar2.d());
        aVar.c().setText(iVar2.c());
        AppCompatImageView b = aVar.b();
        int i3 = !iVar2.a() || this.f10136k ? 4 : 0;
        b.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b, i3);
        AppCompatImageView e2 = aVar.e();
        e2.setVisibility(4);
        VdsAgent.onSetViewVisibility(e2, 4);
        if (l() == i2) {
            aVar.c().setTextColor(ContextCompat.getColor(aVar.a().getContext(), R.color.edit_function_select));
        } else {
            aVar.c().setTextColor(ContextCompat.getColor(aVar.a().getContext(), R.color.edit_function_unselect));
        }
        if (iVar2.j()) {
            if (iVar2.k()) {
                us.pinguo.foundation.utils.q qVar = us.pinguo.foundation.utils.q.a;
                Context context = aVar.a().getContext();
                kotlin.jvm.internal.s.g(context, "holder.imgIcon.context");
                qVar.a(context, R.color.edit_function_select, R.drawable.icon_beauty_skinrefresh_xiangpica, aVar.h());
                Context context2 = aVar.a().getContext();
                kotlin.jvm.internal.s.g(context2, "holder.imgIcon.context");
                qVar.a(context2, R.color.edit_function_unselect, iVar2.d(), aVar.a());
                return;
            }
            us.pinguo.foundation.utils.q qVar2 = us.pinguo.foundation.utils.q.a;
            Context context3 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context3, "holder.imgIcon.context");
            int i4 = R.color.edit_function_unselect;
            qVar2.a(context3, i4, R.drawable.icon_beauty_skinrefresh_xiangpica, aVar.h());
            if (l() == i2) {
                Context context4 = aVar.a().getContext();
                kotlin.jvm.internal.s.g(context4, "holder.imgIcon.context");
                qVar2.a(context4, R.color.edit_function_select, iVar2.d(), aVar.a());
                return;
            }
            Context context5 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context5, "holder.imgIcon.context");
            qVar2.a(context5, i4, iVar2.d(), aVar.a());
        } else if (l() == i2) {
            us.pinguo.foundation.utils.q qVar3 = us.pinguo.foundation.utils.q.a;
            Context context6 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context6, "holder.imgIcon.context");
            qVar3.a(context6, R.color.edit_function_select, iVar2.d(), aVar.a());
        } else {
            us.pinguo.foundation.utils.q qVar4 = us.pinguo.foundation.utils.q.a;
            Context context7 = aVar.a().getContext();
            kotlin.jvm.internal.s.g(context7, "holder.imgIcon.context");
            qVar4.a(context7, R.color.edit_function_unselect, iVar2.d(), aVar.a());
        }
    }

    private final void N(p0.a aVar, long j2, us.pinguo.edit2020.bean.n0 n0Var) {
        if (!kotlin.jvm.internal.s.c(n0Var.f(), this.f10134i) && !kotlin.jvm.internal.s.c(n0Var.f(), this.f10135j)) {
            AppCompatImageView h2 = aVar.h();
            h2.setVisibility(0);
            VdsAgent.onSetViewVisibility(h2, 0);
            View g2 = aVar.g();
            g2.setVisibility(0);
            VdsAgent.onSetViewVisibility(g2, 0);
            ViewPropertyAnimator animate = aVar.a().animate();
            Context b = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b, "getAppContext()");
            animate.translationX(-us.pinguo.util.g.a(b, 20.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
            ViewPropertyAnimator animate2 = aVar.i().animate();
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            animate2.translationX(-us.pinguo.util.g.a(b2, 20.0f)).setDuration(j2).setInterpolator(new DecelerateInterpolator()).start();
            ViewPropertyAnimator animate3 = aVar.h().animate();
            Context b3 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b3, "getAppContext()");
            animate3.translationX(us.pinguo.util.g.a(b3, 20.0f)).setDuration(j2).start();
            return;
        }
        G(this, aVar, 0, 2, null);
    }

    public final void M(boolean z) {
        this.f10136k = z;
    }

    @Override // us.pinguo.edit2020.adapter.a0, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(final b0 holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        Object obj = h().get(i2);
        kotlin.jvm.internal.s.g(obj, "dataList[position]");
        final us.pinguo.edit2020.bean.i iVar = (us.pinguo.edit2020.bean.i) obj;
        if (holder instanceof p0.a) {
            p0.a aVar = (p0.a) holder;
            L(aVar, i2);
            if (iVar.j() && l() == i2) {
                N(aVar, 0L, iVar);
            } else {
                F(aVar, i2);
            }
            aVar.h().setTag(Integer.valueOf(i2));
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l0.K(us.pinguo.edit2020.bean.i.this, this, i2, holder, view);
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
        return new p0.a(inflate);
    }

    @Override // us.pinguo.edit2020.adapter.a0
    public void s(Integer num) {
        B(num == null ? -1 : num.intValue());
        notifyDataSetChanged();
        if (num == null) {
            return;
        }
        if (h().get(num.intValue()).k()) {
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.i, kotlin.u> j2 = j();
            if (j2 == null) {
                return;
            }
            us.pinguo.edit2020.bean.i iVar = h().get(num.intValue());
            kotlin.jvm.internal.s.g(iVar, "dataList[selected]");
            j2.invoke(-2, iVar);
            return;
        }
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.i, kotlin.u> j3 = j();
        if (j3 == null) {
            return;
        }
        us.pinguo.edit2020.bean.i iVar2 = h().get(num.intValue());
        kotlin.jvm.internal.s.g(iVar2, "dataList[selected]");
        j3.invoke(num, iVar2);
    }
}
