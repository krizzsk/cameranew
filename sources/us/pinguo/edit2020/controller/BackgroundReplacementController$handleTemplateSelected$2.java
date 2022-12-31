package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$handleTemplateSelected$2 extends Lambda implements kotlin.jvm.b.q<Boolean, String, Boolean, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.bean.f $func;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$handleTemplateSelected$2(BackgroundReplacementController backgroundReplacementController, us.pinguo.edit2020.bean.f fVar) {
        super(3);
        this.this$0 = backgroundReplacementController;
        this.$func = fVar;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, String str, Boolean bool2) {
        invoke(bool.booleanValue(), str, bool2.booleanValue());
        return kotlin.u.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if ((r2.getVisibility() == 0) == true) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(boolean r2, java.lang.String r3, boolean r4) {
        /*
            r1 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.s.h(r3, r0)
            if (r2 == 0) goto L2a
            if (r4 == 0) goto L2a
            us.pinguo.edit2020.controller.BackgroundReplacementController r2 = r1.this$0
            us.pinguo.edit2020.view.ManualMattingView r2 = us.pinguo.edit2020.controller.BackgroundReplacementController.J(r2)
            r4 = 1
            r0 = 0
            if (r2 != 0) goto L15
        L13:
            r4 = 0
            goto L20
        L15:
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            if (r2 != r4) goto L13
        L20:
            if (r4 != 0) goto L2a
            us.pinguo.edit2020.controller.BackgroundReplacementController r2 = r1.this$0
            us.pinguo.edit2020.bean.f r4 = r1.$func
            us.pinguo.edit2020.controller.BackgroundReplacementController.h(r2, r3, r4)
            goto L33
        L2a:
            us.pinguo.edit2020.controller.BackgroundReplacementController r2 = r1.this$0
            us.pinguo.edit2020.adapter.u r2 = us.pinguo.edit2020.controller.BackgroundReplacementController.U(r2)
            r2.n(r3)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.BackgroundReplacementController$handleTemplateSelected$2.invoke(boolean, java.lang.String, boolean):void");
    }
}
