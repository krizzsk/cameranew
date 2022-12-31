package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajp implements AdapterStatus {
    private final String description;
    private final int zzdiv;
    private final AdapterStatus.State zzdix;

    public zzajp(AdapterStatus.State state, String str, int i2) {
        this.zzdix = state;
        this.description = str;
        this.zzdiv = i2;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzdix;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzdiv;
    }
}
