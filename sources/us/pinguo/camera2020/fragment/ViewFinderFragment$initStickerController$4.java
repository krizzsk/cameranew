package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$initStickerController$4 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initStickerController$4(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        us.pinguo.foundation.i P1;
        us.pinguo.foundation.i P12;
        if (z) {
            this.this$0.M1(false);
            P1 = this.this$0.P1();
            if (P1.b()) {
                P12 = this.this$0.P1();
                P12.j();
                return;
            }
            return;
        }
        ViewFinderFragment.g4(this.this$0, null, 1, null);
    }
}
