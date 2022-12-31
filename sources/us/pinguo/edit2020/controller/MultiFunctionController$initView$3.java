package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiFunctionController.kt */
/* loaded from: classes4.dex */
public final class MultiFunctionController$initView$3 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ MultiFunctionController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiFunctionController$initView$3(MultiFunctionController multiFunctionController) {
        super(1);
        this.this$0 = multiFunctionController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String type) {
        String[] strArr;
        int s;
        kotlin.jvm.internal.s.h(type, "type");
        us.pinguo.edit2020.bean.i r = this.this$0.r();
        strArr = this.this$0.f10409e;
        if (strArr != null) {
            s = this.this$0.s();
            strArr[s] = type;
            this.this$0.C(r);
            this.this$0.b.q0(r.g());
            return;
        }
        kotlin.jvm.internal.s.z("toggleSwitchArrays");
        throw null;
    }
}
