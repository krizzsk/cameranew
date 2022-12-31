package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdjustController.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class AdjustController$show$1 extends FunctionReferenceImpl implements kotlin.jvm.b.r<Integer, Integer, us.pinguo.edit2020.bean.a, us.pinguo.edit2020.adapter.b0, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdjustController$show$1(Object obj) {
        super(4, obj, AdjustController.class, "bindViewHolder", "bindViewHolder(IILus/pinguo/edit2020/bean/AdjustFunction;Lus/pinguo/edit2020/adapter/EditFunctionItemHolder;)V", 0);
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, Integer num2, us.pinguo.edit2020.bean.a aVar, us.pinguo.edit2020.adapter.b0 b0Var) {
        invoke(num.intValue(), num2.intValue(), aVar, b0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, int i3, us.pinguo.edit2020.bean.a p2, us.pinguo.edit2020.adapter.b0 p3) {
        kotlin.jvm.internal.s.h(p2, "p2");
        kotlin.jvm.internal.s.h(p3, "p3");
        ((AdjustController) this.receiver).C(i2, i3, p2, p3);
    }
}
