package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbta extends zzbwf<AdMetadataListener> implements zzahi {
    private Bundle zzfzm;

    public zzbta(Set<zzbya<AdMetadataListener>> set) {
        super(set);
        this.zzfzm = new Bundle();
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfzm);
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfzm.putAll(bundle);
        zza(zzbtd.zzfzg);
    }
}
