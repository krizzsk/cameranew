package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdpv implements zzdzl<zzdpm<AdT>> {
    private final /* synthetic */ zzdpu zzhox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdpv(zzdpu zzdpuVar) {
        this.zzhox = zzdpuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdpx zzdpxVar;
        int i2;
        int i3;
        zzeae zzeaeVar;
        zzdqa zzdqaVar;
        zzdpc zzdpcVar;
        zzdqa zzdqaVar2;
        zzdpm<?> zzdpmVar = (zzdpm) obj;
        synchronized (this.zzhox) {
            zzdpxVar = this.zzhox.zzhou;
            zzdpxVar.zza(zzdpmVar);
            i2 = this.zzhox.zzhot;
            if (i2 != zzdpz.zzhpa) {
                zzdpcVar = this.zzhox.zzhhi;
                zzdqaVar2 = this.zzhox.zzhoq;
                zzdpcVar.zza(zzdqaVar2.zzaup(), zzdpmVar);
            }
            i3 = this.zzhox.zzhot;
            int i4 = zzdpz.zzhoz;
            if (i3 == i4) {
                zzdpu zzdpuVar = this.zzhox;
                zzdqaVar = zzdpuVar.zzhoq;
                zzdpuVar.zzd(zzdqaVar);
            }
            this.zzhox.zzhot = i4;
            zzeaeVar = this.zzhox.zzhor;
            zzeaeVar.set(zzdpmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdpx zzdpxVar;
        zzeae zzeaeVar;
        synchronized (this.zzhox) {
            zzdpxVar = this.zzhox.zzhou;
            zzdpxVar.zzb(th);
            zzeaeVar = this.zzhox.zzhor;
            zzeaeVar.setException(th);
        }
    }
}
