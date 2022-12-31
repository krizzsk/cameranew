package com.pinguo.camera360.camera.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.foundation.utils.j0;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VipHalfScreenController.kt */
/* loaded from: classes3.dex */
public final class VipHalfScreenController$inflateLayoutForGroupB$3$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VipHalfScreenController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipHalfScreenController$inflateLayoutForGroupB$3$1(Context context, VipHalfScreenController vipHalfScreenController) {
        super(1);
        this.$context = context;
        this.this$0 = vipHalfScreenController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        if (z) {
            j0.d(this.$context.getString(R.string.vip_half_screen_purchase_success));
            this.this$0.closePopupWindow();
            return;
        }
        j0.d(this.$context.getString(R.string.vip_half_screen_purchase_fail));
    }
}
