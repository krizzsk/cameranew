package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.c;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.component.reward.g;
/* loaded from: classes.dex */
public class TTC3Proxy {
    public static void a(Context context) {
        try {
            g.a(context).b();
        } catch (Throwable unused) {
        }
        try {
            c.a(context).a();
        } catch (Throwable unused2) {
        }
    }

    public static void loadFull(Context context, AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        c.a(context).a(adSlot, fullScreenVideoAdListener);
    }

    public static void loadReward(Context context, AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        g.a(context).a(adSlot, rewardVideoAdListener);
    }

    public static void verityPlayable(String str, int i2, String str2, String str3, String str4) {
        d.a(str, i2, str2, str3, str4);
    }
}
