package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
/* renamed from: com.facebook.ads.redexgen.X.aX  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1401aX implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1401aX(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityManager activityManager;
        ActivityManager activityManager2;
        if (Build.VERSION.SDK_INT >= 16) {
            activityManager = this.A00.A02;
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager2 = this.A00.A02;
                activityManager2.getMemoryInfo(memoryInfo);
                return this.A00.A06(memoryInfo.totalMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
