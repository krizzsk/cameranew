package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztz {
    zzhb zzbyg;
    boolean zzbyh;

    public zztz(Context context, String str, String str2) {
        zzabp.initialize(context);
        try {
            this.zzbyg = (zzhb) zzazj.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzuc.zzbyi);
            d.z0(context);
            this.zzbyg.zza(d.z0(context), str, null);
            this.zzbyh = true;
        } catch (RemoteException | zzazl | NullPointerException unused) {
            zzazk.zzdy("Cannot dynamite load clearcut");
        }
    }

    public final zzud zzf(byte[] bArr) {
        return new zzud(this, bArr);
    }

    public zztz(Context context) {
        zzabp.initialize(context);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvg)).booleanValue()) {
            try {
                this.zzbyg = (zzhb) zzazj.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzub.zzbyi);
                d.z0(context);
                this.zzbyg.zza(d.z0(context), "GMA_SDK");
                this.zzbyh = true;
            } catch (RemoteException | zzazl | NullPointerException unused) {
                zzazk.zzdy("Cannot dynamite load clearcut");
            }
        }
    }

    public zztz() {
    }
}
