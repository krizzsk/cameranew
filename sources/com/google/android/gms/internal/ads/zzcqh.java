package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzug;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqh implements zzdzl<Bundle> {
    private final /* synthetic */ boolean zzgrd;
    final /* synthetic */ zzcqi zzgre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqh(zzcqi zzcqiVar, boolean z) {
        this.zzgre = zzcqiVar;
        this.zzgrd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        final ArrayList zzl;
        final zzug.zzo.zzc zzk;
        final zzug.zzm zzj;
        zzcpv zzcpvVar;
        Bundle bundle2 = bundle;
        zzcqi zzcqiVar = this.zzgre;
        zzl = zzcqi.zzl(bundle2);
        zzcqi zzcqiVar2 = this.zzgre;
        zzk = zzcqi.zzk(bundle2);
        zzj = this.zzgre.zzj(bundle2);
        zzcpvVar = this.zzgre.zzgrg;
        final boolean z = this.zzgrd;
        zzcpvVar.zza(new zzdqu(this, z, zzl, zzj, zzk) { // from class: com.google.android.gms.internal.ads.zzcqk
            private final boolean zzekn;
            private final zzcqh zzgrk;
            private final ArrayList zzgrl;
            private final zzug.zzm zzgrm;
            private final zzug.zzo.zzc zzgrn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrk = this;
                this.zzekn = z;
                this.zzgrl = zzl;
                this.zzgrm = zzj;
                this.zzgrn = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzdqu
            public final Object apply(Object obj) {
                byte[] zza;
                zzcqh zzcqhVar = this.zzgrk;
                boolean z2 = this.zzekn;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                zza = zzcqhVar.zzgre.zza(z2, this.zzgrl, this.zzgrm, this.zzgrn);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
                contentValues.put("serialized_proto_data", zza);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzazk.zzev("Failed to get signals bundle");
    }
}
