package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajo implements InitializationStatus {
    private final Map<String, AdapterStatus> zzdiw;

    public zzajo(Map<String, AdapterStatus> map) {
        this.zzdiw = map;
    }

    @Override // com.google.android.gms.ads.initialization.InitializationStatus
    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzdiw;
    }
}
