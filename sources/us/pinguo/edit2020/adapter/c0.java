package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Set;
import us.pinguo.edit2020.R;
/* compiled from: Facial3DAdapter.kt */
/* loaded from: classes4.dex */
public final class c0 extends a0<us.pinguo.edit2020.bean.q> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(c0 this$0, int i2, us.pinguo.edit2020.bean.q function, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(function, "$function");
        if (this$0.l() == i2) {
            return;
        }
        if (this$0.m() != null) {
            Set<Integer> m = this$0.m();
            kotlin.jvm.internal.s.e(m);
            if (m.contains(Integer.valueOf(i2))) {
                kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.q, kotlin.u> j2 = this$0.j();
                if (j2 == null) {
                    return;
                }
                j2.invoke(Integer.valueOf(i2), function);
                return;
            }
        }
        int l2 = this$0.l();
        this$0.B(i2);
        if (l2 >= 0) {
            this$0.notifyItemChanged(l2);
        }
        this$0.notifyItemChanged(i2);
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.q, kotlin.u> j3 = this$0.j();
        if (j3 == null) {
            return;
        }
        j3.invoke(Integer.valueOf(i2), function);
    }

    private final void g(b0 b0Var, final int i2) {
        us.pinguo.edit2020.bean.q qVar = h().get(i2);
        kotlin.jvm.internal.s.g(qVar, "dataList[position]");
        final us.pinguo.edit2020.bean.q qVar2 = qVar;
        b0Var.a().setImageResource(qVar2.d());
        b0Var.c().setText(qVar2.c());
        AppCompatImageView e2 = b0Var.e();
        int i3 = qVar2.e() ^ true ? 4 : 0;
        e2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(e2, i3);
        Context context = b0Var.a().getContext();
        if (l() == i2) {
            us.pinguo.foundation.utils.q qVar3 = us.pinguo.foundation.utils.q.a;
            kotlin.jvm.internal.s.g(context, "context");
            int i4 = R.color.edit_function_select;
            qVar3.a(context, i4, qVar2.d(), b0Var.a());
            b0Var.c().setTextColor(ContextCompat.getColor(context, i4));
            b0Var.e().setImageResource(R.drawable.dot_selected);
        } else {
            us.pinguo.foundation.utils.q qVar4 = us.pinguo.foundation.utils.q.a;
            kotlin.jvm.internal.s.g(context, "context");
            int i5 = R.color.edit_function_unselect;
            qVar4.a(context, i5, qVar2.d(), b0Var.a());
            b0Var.c().setTextColor(ContextCompat.getColor(context, i5));
            b0Var.e().setImageResource(R.drawable.dot_unselect);
        }
        b0Var.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0.F(c0.this, i2, qVar2, view);
            }
        });
    }

    public final void H() {
        notifyItemRangeChanged(0, getItemCount());
    }

    @Override // us.pinguo.edit2020.adapter.a0, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(b0 holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        g(holder, i2);
    }
}
