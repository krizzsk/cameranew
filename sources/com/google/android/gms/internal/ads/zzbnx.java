package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbnx<AdT> implements zzbny<AdT> {
    private final Map<String, zzcrj<AdT>> zzfwj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnx(Map<String, zzcrj<AdT>> map) {
        this.zzfwj = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbny
    @Nullable
    public final zzcrj<AdT> zze(int i2, String str) {
        return this.zzfwj.get(str);
    }
}
