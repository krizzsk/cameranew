package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzud {
    private final byte[] zzbyj;
    private int zzbyk;
    private int zzbyl;
    private final /* synthetic */ zztz zzbym;

    private zzud(zztz zztzVar, byte[] bArr) {
        this.zzbym = zztzVar;
        this.zzbyj = bArr;
    }

    public final synchronized void log() {
        try {
            zztz zztzVar = this.zzbym;
            if (zztzVar.zzbyh) {
                zztzVar.zzbyg.zzc(this.zzbyj);
                this.zzbym.zzbyg.zzs(this.zzbyk);
                this.zzbym.zzbyg.zzt(this.zzbyl);
                this.zzbym.zzbyg.zza(null);
                this.zzbym.zzbyg.log();
            }
        } catch (RemoteException e2) {
            zzazk.zzb("Clearcut log failed", e2);
        }
    }

    public final zzud zzbu(int i2) {
        this.zzbyk = i2;
        return this;
    }

    public final zzud zzbv(int i2) {
        this.zzbyl = i2;
        return this;
    }
}
