package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
/* compiled from: TTNativeExpressDrawVideoAdImpl.java */
/* loaded from: classes.dex */
public class m extends n {
    public m(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        super(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.n, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f1724d = "draw_ad";
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, hVar, adSlot, "draw_ad");
        this.a = nativeExpressVideoView;
        a(nativeExpressVideoView, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
