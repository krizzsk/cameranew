package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* compiled from: TTNativeExpressVideoAdImpl.java */
/* loaded from: classes.dex */
public class n extends k {
    public n(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        super(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, hVar, adSlot, "embeded_ad");
        this.a = nativeExpressVideoView;
        a(nativeExpressVideoView, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(expressVideoAdListener);
        }
    }
}
