package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.R;
/* compiled from: GraffitiColorAdapter.kt */
/* loaded from: classes4.dex */
public final class e0 extends RecyclerView.Adapter<f0> {
    private m0 a;
    private String[] b;
    private int c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e0 this$0, int i2, f0 holder, String color, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(color, "$color");
        int i3 = this$0.c;
        this$0.c = i2;
        this$0.notifyItemChanged(i3);
        this$0.notifyItemChanged(i2);
        m0 m0Var = this$0.a;
        if (m0Var == null) {
            return;
        }
        m0Var.a(holder.itemView, i2, color);
    }

    public final String[] e() {
        return this.b;
    }

    public final int f() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        String[] strArr = this.b;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001a  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(final us.pinguo.edit2020.adapter.f0 r6, final int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.s.h(r6, r0)
            java.lang.String[] r0 = r5.b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L16
            int r3 = r0.length
            if (r3 != 0) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r3 == 0) goto L14
            goto L16
        L14:
            r3 = 0
            goto L17
        L16:
            r3 = 1
        L17:
            if (r3 == 0) goto L1a
            return
        L1a:
            kotlin.jvm.internal.s.e(r0)
            r0 = r0[r7]
            us.pinguo.edit2020.view.CheckMarkCircleView r3 = r6.a()
            int r4 = android.graphics.Color.parseColor(r0)
            r3.setColor(r4)
            us.pinguo.edit2020.view.CheckMarkCircleView r3 = r6.a()
            int r4 = r5.c
            if (r7 != r4) goto L33
            r1 = 1
        L33:
            r3.setEnableRing(r1)
            android.view.View r1 = r6.itemView
            us.pinguo.edit2020.adapter.f r2 = new us.pinguo.edit2020.adapter.f
            r2.<init>()
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.adapter.e0.onBindViewHolder(us.pinguo.edit2020.adapter.f0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public f0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.layout_graffiti_color_item, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(Foundation.getAppCo…olor_item, parent, false)");
        return new f0(inflate);
    }

    public final void k(String[] strArr) {
        this.b = strArr;
        notifyDataSetChanged();
    }

    public final void l(int i2) {
        int i3 = this.c;
        if (i2 == i3) {
            return;
        }
        this.c = i2;
        notifyItemChanged(i3);
        notifyItemChanged(i2);
    }

    public final void m(m0 m0Var) {
        this.a = m0Var;
    }
}
