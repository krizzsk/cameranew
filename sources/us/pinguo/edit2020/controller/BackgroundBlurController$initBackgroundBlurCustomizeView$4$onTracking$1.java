package us.pinguo.edit2020.controller;

import android.view.TextureView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
final class BackgroundBlurController$initBackgroundBlurCustomizeView$4$onTracking$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ TextureView $texViewHint;
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$initBackgroundBlurCustomizeView$4$onTracking$1(BackgroundBlurController backgroundBlurController, TextureView textureView) {
        super(0);
        this.this$0 = backgroundBlurController;
        this.$texViewHint = textureView;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.c.d0();
        TextureView texViewHint = this.$texViewHint;
        kotlin.jvm.internal.s.g(texViewHint, "texViewHint");
        texViewHint.setVisibility(0);
        VdsAgent.onSetViewVisibility(texViewHint, 0);
    }
}
