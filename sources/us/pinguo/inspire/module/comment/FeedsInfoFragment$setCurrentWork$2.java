package us.pinguo.inspire.module.comment;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedsInfoFragment.kt */
/* loaded from: classes9.dex */
public final class FeedsInfoFragment$setCurrentWork$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ FeedsInfoFragment$setCurrentWork$runnable$1 $runnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsInfoFragment$setCurrentWork$2(FeedsInfoFragment$setCurrentWork$runnable$1 feedsInfoFragment$setCurrentWork$runnable$1) {
        super(0);
        this.$runnable = feedsInfoFragment$setCurrentWork$runnable$1;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$runnable.run();
    }
}
