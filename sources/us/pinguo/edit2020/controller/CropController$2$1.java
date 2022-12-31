package us.pinguo.edit2020.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropController.kt */
/* loaded from: classes4.dex */
public final class CropController$2$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.x, kotlin.u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CropController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropController$2$1(CropController cropController, Context context) {
        super(2);
        this.this$0 = cropController;
        this.$context = context;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.x xVar) {
        invoke(num.intValue(), xVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.x function) {
        kotlin.jvm.internal.s.h(function, "function");
        this.this$0.p[this.this$0.q] = Integer.valueOf(i2);
        CenterLayoutManager centerLayoutManager = this.this$0.A;
        Context context = this.$context;
        kotlin.jvm.internal.s.g(context, "context");
        centerLayoutManager.b(context, i2, 100.0f);
        this.this$0.c0(function.f());
    }
}
