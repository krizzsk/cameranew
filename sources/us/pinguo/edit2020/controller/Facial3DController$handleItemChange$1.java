package us.pinguo.edit2020.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Facial3DController.kt */
/* loaded from: classes4.dex */
public final class Facial3DController$handleItemChange$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ us.pinguo.edit2020.bean.q $function;
    final /* synthetic */ CenterLayoutManager $layoutManager;
    final /* synthetic */ int $position;
    final /* synthetic */ Facial3DController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Facial3DController$handleItemChange$1(Facial3DController facial3DController, int i2, CenterLayoutManager centerLayoutManager, Context context, us.pinguo.edit2020.bean.q qVar) {
        super(1);
        this.this$0 = facial3DController;
        this.$position = i2;
        this.$layoutManager = centerLayoutManager;
        this.$context = context;
        this.$function = qVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        int i2;
        if (z) {
            this.this$0.a.j0();
            Facial3DController.s(this.this$0, this.$position, this.$layoutManager, this.$context, this.$function);
            us.pinguo.edit2020.adapter.c0 c0Var = this.this$0.f10363f;
            if (c0Var == null) {
                return;
            }
            c0Var.H();
            return;
        }
        us.pinguo.edit2020.adapter.c0 c0Var2 = this.this$0.f10363f;
        if (c0Var2 == null) {
            return;
        }
        i2 = this.this$0.f10364g;
        c0Var2.v(i2);
    }
}
