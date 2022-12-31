package com.bytedance.sdk.openadsdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.banner.b;
/* loaded from: classes.dex */
public class TTC1Proxy {
    public static void load(Context context, AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        b.a(context).a(adSlot, bannerAdListener);
    }
}
