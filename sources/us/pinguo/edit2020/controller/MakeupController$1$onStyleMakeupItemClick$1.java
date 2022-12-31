package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.repository2020.entity.StyleMakeup;
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
final class MakeupController$1$onStyleMakeupItemClick$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeupController$1$onStyleMakeupItemClick$1(MakeupController makeupController, StyleMakeup styleMakeup) {
        super(1);
        this.this$0 = makeupController;
        this.$styleMakeup = styleMakeup;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.c0(this.$styleMakeup, true);
        }
    }
}
