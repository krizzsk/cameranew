package vStudio.Android.Camera360.guide.pageview;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayWallGuideFragment.kt */
/* loaded from: classes7.dex */
public final class PayWallGuideFragment$onViewCreated$3$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ PayWallGuideFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayWallGuideFragment$onViewCreated$3$1(PayWallGuideFragment payWallGuideFragment) {
        super(0);
        this.this$0 = payWallGuideFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e eVar;
        eVar = this.this$0.f12621e;
        if (eVar != null) {
            eVar.a("new user");
        } else {
            s.z("guideModel");
            throw null;
        }
    }
}
