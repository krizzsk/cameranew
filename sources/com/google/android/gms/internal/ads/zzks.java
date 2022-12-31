package com.google.android.gms.internal.ads;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzks implements zzkn {
    private final /* synthetic */ zzkq zzasr;

    private zzks(zzkq zzkqVar) {
        this.zzasr = zzkqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zza(int i2, double d2) throws zzhw {
        this.zzasr.zza(i2, d2);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final int zzal(int i2) {
        return zzkq.zzal(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final boolean zzam(int i2) {
        return zzkq.zzam(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zzan(int i2) throws zzhw {
        this.zzasr.zzan(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zzd(int i2, long j2, long j3) throws zzhw {
        this.zzasr.zzd(i2, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzks(zzkq zzkqVar, zzkp zzkpVar) {
        this(zzkqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zza(int i2, String str) throws zzhw {
        this.zzasr.zza(i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zzd(int i2, long j2) throws zzhw {
        this.zzasr.zzd(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzkn
    public final void zza(int i2, int i3, zzjz zzjzVar) throws IOException, InterruptedException {
        this.zzasr.zza(i2, i3, zzjzVar);
    }
}
