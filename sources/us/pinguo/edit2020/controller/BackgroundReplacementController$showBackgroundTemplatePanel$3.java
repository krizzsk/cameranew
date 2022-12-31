package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class BackgroundReplacementController$showBackgroundTemplatePanel$3 extends FunctionReferenceImpl implements kotlin.jvm.b.q<Integer, us.pinguo.edit2020.bean.f, Boolean, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundReplacementController$showBackgroundTemplatePanel$3(Object obj) {
        super(3, obj, BackgroundReplacementController.class, "handleTemplateSelected", "handleTemplateSelected(ILus/pinguo/edit2020/bean/BackgroundReplacementFunction;Z)V", 0);
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.f fVar, Boolean bool) {
        invoke(num.intValue(), fVar, bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.f p1, boolean z) {
        kotlin.jvm.internal.s.h(p1, "p1");
        ((BackgroundReplacementController) this.receiver).A0(i2, p1, z);
    }
}
