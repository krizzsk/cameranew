package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcpx implements zzdzl<SQLiteDatabase> {
    private final /* synthetic */ zzdqu zzgqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcpx(zzcpv zzcpvVar, zzdqu zzdquVar) {
        this.zzgqm = zzdquVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(SQLiteDatabase sQLiteDatabase) {
        try {
            this.zzgqm.apply(sQLiteDatabase);
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzazk.zzev(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzazk.zzev(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }
}
