package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: LongLegController.kt */
/* loaded from: classes4.dex */
/* synthetic */ class LongLegController$onWorkflowStarted$6 extends FunctionReferenceImpl implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.b0, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LongLegController$onWorkflowStarted$6(Object obj) {
        super(2, obj, LongLegController.class, "handleFunctionItemSelected", "handleFunctionItemSelected(ILus/pinguo/edit2020/bean/LongLegFunction;)V", 0);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.b0 b0Var) {
        invoke(num.intValue(), b0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.b0 p1) {
        kotlin.jvm.internal.s.h(p1, "p1");
        ((LongLegController) this.receiver).w(i2, p1);
    }
}
