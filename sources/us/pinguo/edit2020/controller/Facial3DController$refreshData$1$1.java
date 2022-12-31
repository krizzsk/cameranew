package us.pinguo.edit2020.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Facial3DController.kt */
/* loaded from: classes4.dex */
public final class Facial3DController$refreshData$1$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.q, kotlin.u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CenterLayoutManager $layoutManager;
    final /* synthetic */ Facial3DController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Facial3DController$refreshData$1$1(Facial3DController facial3DController, CenterLayoutManager centerLayoutManager, Context context) {
        super(2);
        this.this$0 = facial3DController;
        this.$layoutManager = centerLayoutManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.q qVar) {
        invoke(num.intValue(), qVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.q function) {
        kotlin.jvm.internal.s.h(function, "function");
        Facial3DController facial3DController = this.this$0;
        CenterLayoutManager centerLayoutManager = this.$layoutManager;
        Context context = this.$context;
        kotlin.jvm.internal.s.g(context, "context");
        facial3DController.r(function, i2, centerLayoutManager, context);
    }
}
