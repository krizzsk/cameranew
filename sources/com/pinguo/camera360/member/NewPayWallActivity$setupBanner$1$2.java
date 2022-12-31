package com.pinguo.camera360.member;

import kotlin.jvm.internal.Lambda;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewPayWallActivity.kt */
/* loaded from: classes3.dex */
public final class NewPayWallActivity$setupBanner$1$2 extends Lambda implements kotlin.jvm.b.q<Integer, Float, Integer, kotlin.u> {
    final /* synthetic */ NewPayWallActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPayWallActivity$setupBanner$1$2(NewPayWallActivity newPayWallActivity) {
        super(3);
        this.this$0 = newPayWallActivity;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, Float f2, Integer num2) {
        invoke(num.intValue(), f2.floatValue(), num2.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2, float f2, int i3) {
        ((AutofitTextView) this.this$0._$_findCachedViewById(R.id.tvSlogan)).setAlpha(1 - f2);
        this.this$0.w0(i2);
    }
}
