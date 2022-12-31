package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzajd extends zzaiw {
    private final /* synthetic */ zzbaa zzbwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajd(zzaja zzajaVar, zzbaa zzbaaVar) {
        this.zzbwb = zzbaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaix
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbwb.set(parcelFileDescriptor);
    }
}
