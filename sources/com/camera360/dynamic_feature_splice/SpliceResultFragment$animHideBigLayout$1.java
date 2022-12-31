package com.camera360.dynamic_feature_splice;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Lambda;
/* compiled from: SpliceResultFragment.kt */
/* loaded from: classes8.dex */
final class SpliceResultFragment$animHideBigLayout$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ FrameLayout $bigLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceResultFragment$animHideBigLayout$1(FrameLayout frameLayout) {
        super(0);
        this.$bigLayout = frameLayout;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$bigLayout.setVisibility(4);
        this.$bigLayout.removeAllViews();
    }
}
