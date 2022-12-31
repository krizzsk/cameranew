package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcno extends zzatn {
    private final /* synthetic */ zzcnl zzgot;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcno(zzcnl zzcnlVar) {
        this.zzgot = zzcnlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zza(com.google.android.gms.ads.internal.util.zzaq zzaqVar) {
        this.zzgot.zzdlg.setException(new com.google.android.gms.ads.internal.util.zzap(zzaqVar.zzacp, zzaqVar.errorCode));
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgot.zzdlg.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
