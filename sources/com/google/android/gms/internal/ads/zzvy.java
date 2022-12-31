package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvy extends zzxw {
    private final AppEventListener zzboe;

    public zzvy(AppEventListener appEventListener) {
        this.zzboe = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboe;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final void onAppEvent(String str, String str2) {
        this.zzboe.onAppEvent(str, str2);
    }
}
