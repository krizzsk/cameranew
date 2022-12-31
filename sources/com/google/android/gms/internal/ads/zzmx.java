package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzmx implements zznn {
    private final int track;
    private final /* synthetic */ zzms zzbdl;

    public zzmx(zzms zzmsVar, int i2) {
        this.zzbdl = zzmsVar;
        this.track = i2;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean isReady() {
        return this.zzbdl.zzaz(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final int zzb(zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        return this.zzbdl.zza(this.track, zzhvVar, zzjpVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzeh(long j2) {
        this.zzbdl.zze(this.track, j2);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzhs() throws IOException {
        this.zzbdl.zzhs();
    }
}
